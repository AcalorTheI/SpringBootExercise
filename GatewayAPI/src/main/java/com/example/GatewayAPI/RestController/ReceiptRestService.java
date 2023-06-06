package com.example.GatewayAPI.RestController;

import Entity.Article;
import Entity.EventMessage;
import Entity.EventMessageType;
import com.example.GatewayAPI.KakfaCommunication.KafkaCommunicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiptRestService {
    @Autowired
    KafkaCommunicatorService kafkaCommunicatorService;

    /* Nema update za racune moze samo da se stornira/obrise. */
    @GetMapping("/v1/getReceipt/{id}")
    public ResponseEntity<Article> getReceipt(@PathVariable(name = "id") Long id) {
        EventMessage message = EventMessage.builder().messageType(EventMessageType.GET).payload(id).timestamp(System.currentTimeMillis()).build();

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
