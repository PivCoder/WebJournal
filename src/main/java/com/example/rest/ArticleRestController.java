package com.example.rest;

import com.example.model.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/articles")
public class ArticleRestController {

    @GetMapping("/get")
    public ResponseEntity<?> get() {


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    public ResponseEntity<Article> addArticle(@RequestParam String name) {

        Article article = new Article();

        article.setName(name);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

}
