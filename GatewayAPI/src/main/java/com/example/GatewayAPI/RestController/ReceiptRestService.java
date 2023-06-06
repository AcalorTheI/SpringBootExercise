package com.example.GatewayAPI.RestController;

import Entity.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiptRestService {
    /* Nema update za racune moze samo da se stornira/obrise. */
    @GetMapping("/v1/getReceipt/{id}")
    public ResponseEntity<Article> getReceipt(@PathVariable(name = "id") Long id) {

        // neki servis koji ce da dohvata article sa noda preko kafke
        return new ResponseEntity<>(new Article(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/v1/saveReceipt")
    public ResponseEntity<Article> saveReceipt(@RequestBody Article article) {
        return new ResponseEntity<>(article, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/v1/deleteArticle/{id}")
    public ResponseEntity<Article> deleteReceipt(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
