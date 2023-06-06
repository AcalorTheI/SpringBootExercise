package com.example.GatewayAPI.KakfaCommunication;

import Entity.EventMessage;
import org.springframework.stereotype.Component;

@Component
public class KafkaCommunicator {

    public void sendMessage() {

    }

    public EventMessage listForMessage() {

        return new EventMessage();
    }
}
