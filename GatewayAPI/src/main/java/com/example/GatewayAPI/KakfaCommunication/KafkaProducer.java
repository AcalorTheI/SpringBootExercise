package com.example.GatewayAPI.KakfaCommunication;

import Entity.ByteSerializer;
import Entity.EventMessage;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.utils.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private String COM_TOPIC = "Com-1";
    @Autowired
    private KafkaTemplate<String, Bytes> kafkaTemplate;

    public CompletableFuture<SendResult<String, Bytes>> sendMessage(EventMessage message) {

        return kafkaTemplate.send(new ProducerRecord<>(COM_TOPIC, Bytes.wrap(ByteSerializer.serialize(message))));
    }
}
