package com.example.GatewayAPI;

import Entity.Article;
import Entity.ByteSerializer;
import Entity.Receipt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GatewayApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(GatewayApiApplication.class, args);
	}

}
