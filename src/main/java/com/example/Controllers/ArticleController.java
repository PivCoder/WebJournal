package com.example.Controllers;

import com.example.Service.ArticleServiceImplement;
import com.example.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/articles/{id}")
    public Optional<Article> getArticle(@PathVariable("id") long id){
        ArticleServiceImplement articleServiceImplement = new ArticleServiceImplement();
        return articleServiceImplement.getArticleById(id);
    }
}
