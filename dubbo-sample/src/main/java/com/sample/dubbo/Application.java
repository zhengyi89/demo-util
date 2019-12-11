package com.sample.dubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@MapperScan("com.demo.mapper")
public class Application {
	@Value("${book.author}")
	private String author;
	@Value("${book.name}")
	private String name;

	@RequestMapping("/test")
	@ResponseBody
	String index() {
		return "book name:" + name + "and author is " + author;
	}

	public static void main(String[] args) {
		// 两种启动方式
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.run(args);
		SpringApplication.run(Application.class, args);
	}

}
