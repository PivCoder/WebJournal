package com.example.webjournalspring_v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autorization")
public class AutorizationController {
    @GetMapping
    public String showArticlesForm() {
        return "autorization";
    }
}
