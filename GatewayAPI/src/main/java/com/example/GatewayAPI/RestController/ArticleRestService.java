package com.example.GatewayAPI.RestController;

import Entity.Article;
import Entity.EventMessage;
import Entity.EventMessageType;
import com.example.GatewayAPI.KakfaCommunication.KafkaCommunicatorService;
import org.apache.kafka.common.utils.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/article")
public class ArticleRestService {
    @Autowired
    KafkaCommunicatorService kafkaCommunicatorService;
    /* Nema update za racune moze samo da se stornira/obrise. */
    @GetMapping("/v1/getArticle/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable(name = "id") Long id) {
        EventMessage message = EventMessage.builder().messageType(EventMessageType.GET).payload(id).timestamp(System.currentTimeMillis()).build();
        CompletableFuture<SendResult<String, Bytes>> sendResultCompletableFuture = kafkaCommunicatorService.sendMessage(message);

        if(sendResultCompletableFuture.isDone()) {
            return new ResponseEntity<>(new Article(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/saveArticle")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        EventMessage message = EventMessage.builder().messageType(EventMessageType.CREATE).payload(article).timestamp(System.currentTimeMillis()).build();
        CompletableFuture<SendResult<String, Bytes>> sendResultCompletableFuture = kafkaCommunicatorService.sendMessage(message);

        if(sendResultCompletableFuture.isDone()) {
            return new ResponseEntity<>(new Article(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/v1/deleteArticle/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable(name = "id") Long id) {
        EventMessage message = EventMessage.builder().messageType(EventMessageType.DELETE).payload(id).timestamp(System.currentTimeMillis()).build();
        CompletableFuture<SendResult<String, Bytes>> sendResultCompletableFuture = kafkaCommunicatorService.sendMessage(message);

        if(sendResultCompletableFuture.isDone()) {
            return new ResponseEntity<>(new Article(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
