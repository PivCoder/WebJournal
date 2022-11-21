package com.example.webjournalspring_v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@RequestMapping("/home")
@SessionAttributes("homePage")
public class HomeController {

    @GetMapping
    public String showHomeForm() {
        return "home";
    }
}
