package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 两种启动方式
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.run(args);
        SpringApplication.run(Application.class, args);
    }

}
