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
		Article chips = Article.builder().id(1L).barCode("123-431").name("chips").build();
		Article vec = Article.builder().id(2L).barCode("4-143").name("coa cola").build();
		Receipt r = Receipt.builder().id(1L).articlesOnReceipt(List.of(chips, vec)).build();
		byte[] serialize = ByteSerializer.serialize(r);
		Object deserialize = ByteSerializer.deserialize(serialize);


		SpringApplication.run(GatewayApiApplication.class, args);
	}

}
