package com.example.GatewayAPI.KakfaCommunication;

import Entity.EventMessage;
import org.apache.kafka.common.utils.Bytes;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaCommunicatorService {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    KafkaConsumer kafkaConsumer;

    public CompletableFuture<SendResult<String, Bytes>> sendMessage(EventMessage message) {
        return kafkaProducer.sendMessage(message);
    }

    public EventMessage readMessage() {

        return new EventMessage();
    }
}
