package com.example.Controllers;

import com.example.Service.ArticleServiceImplement;
import com.example.model.Article;
import com.example.model.CategoriesArticle;
import com.example.model.StatesArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private ArticleServiceImplement articleServiceImplement;

    @GetMapping("/articles")
    public String showArticles(Model model){
        Iterable<Article> articles = articleServiceImplement.getAllArticles();
        model.addAttribute("articles", articles);
        return "articles";
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable("id") long id, Model model){
        Optional<Article> article = articleServiceImplement.getArticleById(id);
        List<Article> articleList = new ArrayList<>();
        article.ifPresent(articleList::add);
        model.addAttribute("article", articleList);
        return "article_details";
    }

    @GetMapping("/new_article")
    public String addArticle(){
        return "new_article";
    }

    @PostMapping("/new_article")
    public String articlePostAdd(@RequestParam String name, @RequestParam String countPages,
                                 @RequestParam String countVisits, @RequestParam String pictureRef,
                                 @RequestParam String statesArticle, @RequestParam String categoriesArticle,
                                 Model model){
        StatesArticle stateArticle = new StatesArticle();
        stateArticle.setState(statesArticle);
        CategoriesArticle categoryArticle = new CategoriesArticle();
        categoryArticle.setCategory(categoriesArticle);
        Article article = new Article(name, Integer.parseInt(countPages), Integer.parseInt(countVisits),
                pictureRef, stateArticle, categoryArticle);
        articleServiceImplement.addArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/article/{id}/edit")
    public String editArticle(@PathVariable("id") long id, Model model){
        Optional<Article> article = articleServiceImplement.getArticleById(id);
        List<Article> articleList = new ArrayList<>();
        article.ifPresent(articleList::add);
        model.addAttribute("article", articleList);
        return "article_edit";
    }

    //TODO доделать изменение category и state
    @PostMapping("/article/{id}/edit")
    public String articlePostEdit(@PathVariable("id") long id,
                                 @RequestParam String name, @RequestParam String pictureRef,
                                 Model model){
       Article article = articleServiceImplement.getArticleById(id).orElseThrow();
       article.setName(name);
       article.setPictureRef(pictureRef);
       articleServiceImplement.editArticle(article);
       return "redirect:/articles";
    }

    @PostMapping("/article/{id}/delete")
    public String articlePostDelete(@PathVariable long id){
        articleServiceImplement.deleteArticleById(id);
        return "redirect:/articles";
    }
}
