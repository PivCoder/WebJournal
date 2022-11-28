package com.example.Controllers;

import com.example.Service.ArticleServiceImplement;
import com.example.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/new_article")
public class NewArticleController {

    @GetMapping
    public String showArticlesForm() {
        return "new_article";
    }
}
