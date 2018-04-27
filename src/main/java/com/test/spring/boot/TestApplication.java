package com.test.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestApplication {
	@Value("${book.author}")
	private String author;
	@Value("${book.name}")
	private String name;

	@RequestMapping("/")
	String index() {
		return "book name:" + name + "and author is " + author;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
