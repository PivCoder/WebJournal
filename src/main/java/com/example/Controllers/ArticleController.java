package com.example.Controllers;

import com.example.Service.ArticleServiceImplement;
import com.example.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping
    public String showArticlesForm() {
        return "articles";
    }

    @GetMapping("/all_articles")
    public List<Article> getAllEmployees(Model model) {
        ArticleServiceImplement articleServiceImplement = new ArticleServiceImplement();
        model.addAttribute("all_articles", articleServiceImplement.getAllArticles());
        return articleServiceImplement.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> getArticle(@PathVariable("id") long id){
        ArticleServiceImplement articleServiceImplement = new ArticleServiceImplement();
        return articleServiceImplement.getArticleById(id);
    }
}
