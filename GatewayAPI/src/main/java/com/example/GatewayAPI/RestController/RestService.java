package com.example.GatewayAPI.RestController;

import Entity.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {
    @PostMapping("v2/saveArticle")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        return new ResponseEntity<>(article, HttpStatus.ACCEPTED);
    }
}
