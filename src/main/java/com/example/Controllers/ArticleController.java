package com.example.Controllers;

import com.example.Service.ArticleServiceImplement;
import com.example.Service.AuthorizationServiceImplement;
import com.example.model.Article;
import com.example.model.Authorization;
import com.example.model.Enums.Categories;
import com.example.model.Enums.States;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private ArticleServiceImplement articleServiceImplement;

    private AuthorizationServiceImplement authorizationServiceImplement;
    private PasswordEncoder passwordEncoder;
    private final String FILE_PATH = "C:/JAVA_Projects/Articles/";

    public ArticleController(AuthorizationServiceImplement authorizationServiceImplement,
                             PasswordEncoder passwordEncoder){
        this.authorizationServiceImplement = authorizationServiceImplement;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/articles")
    public String showArticles(Model model) {
        Iterable<Article> articles = articleServiceImplement.getAllArticles();
        model.addAttribute("articles", articles);
        return "articles";
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable("id") long id, Model model) throws IOException {
        Optional<Article> article = articleServiceImplement.getArticleById(id);
        List<Article> articleList = new ArrayList<>();
        article.ifPresent(articleList::add);
        model.addAttribute("article", articleList);

        try (FileInputStream fileInputStream =
                     new FileInputStream(FILE_PATH + "/" + articleList.get(0).getName() + ".docx")){

            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
            XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
            model.addAttribute("articleText", extractor.getText());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "article_details";
    }

    @GetMapping("/new_article")
    public String addArticle() {
        return "new_article";
    }

    @PostMapping("/new_article")
    public String articlePostAdd(@RequestParam String name, @RequestParam String countPages,
                                 @RequestParam String countVisits, @RequestParam String pictureRef,
                                 @RequestParam States stateArticle, @RequestParam Categories categoryArticle,
                                 @RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:articles";
        }

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(FILE_PATH + name + ".docx")));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Article article = new Article(name, Integer.parseInt(countPages), Integer.parseInt(countVisits),
                pictureRef, stateArticle, categoryArticle);
        articleServiceImplement.addArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/article/{id}/edit")
    public String editArticle(@PathVariable("id") long id, Model model) {
        Optional<Article> article = articleServiceImplement.getArticleById(id);
        List<Article> articleList = new ArrayList<>();
        article.ifPresent(articleList::add);
        model.addAttribute("article", articleList);
        return "article_edit";
    }

    @PostMapping("/article/{id}/edit")
    public String articlePostEdit(@PathVariable("id") long id,
                                  @RequestParam String name, @RequestParam String countPages,
                                  @RequestParam String countVisits, @RequestParam String pictureRef,
                                  @RequestParam States stateArticle, @RequestParam Categories categoryArticle,
                                  Model model) {
        Article article = articleServiceImplement.getArticleById(id).orElseThrow();
        article.setName(name);
        article.setCountPages(Integer.parseInt(countPages));
        article.setCountVisits(Integer.parseInt(countVisits));
        article.setPictureRef(pictureRef);
        article.setState(stateArticle);
        article.setCategory(categoryArticle);
        articleServiceImplement.editArticle(article);
        return "redirect:/articles";
    }

    @PostMapping("/article/{id}/delete")
    public String articlePostDelete(@PathVariable long id) {
        articleServiceImplement.deleteArticleById(id);
        return "redirect:/articles";
    }

    @GetMapping("/register_new_user")
    public String reloadArticlesPage() {
        return "redirect:/articles";
    }

    @PostMapping("/register_new_user")
    public String userPostCreate(@RequestParam String username, @RequestParam String password) {
        Authorization authorization = new Authorization();
        authorization.setUsername(username);
        authorization.setPassword(passwordEncoder.encode(password));
        authorizationServiceImplement.addAuthorization(authorization);
        return "redirect:/articles";
    }
}
