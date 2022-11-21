package com.example.webjournalspring_v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Article")
public class ArticleController {
    @GetMapping
    public String showDesignForm() {
        return "Article";
    }
}
