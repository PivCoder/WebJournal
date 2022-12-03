package com.example.Controllers;

import com.example.Service.ArticleServiceImplement;
import com.example.model.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/new_article")
public class NewArticleController {

    @Bean
    public Article articleData(){
        return new Article();
    }

    @GetMapping
    public String showArticlesForm() {
        return "new_article";
    }

    @PostMapping("/new_article")
    public String createArticle(@Valid @ModelAttribute Article newArticle, Model model){
        model.addAttribute("newArticle", newArticle);
        return "redirect:/articles";
    }
}
