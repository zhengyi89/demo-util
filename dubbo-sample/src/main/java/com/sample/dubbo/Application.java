package com.sample.dubbo;

//import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@MapperScan("com.demo.mapper")
public class Application {


    @RequestMapping("/test")
    @ResponseBody
    String index() {
        return "book name:";
    }

    public static void main(String[] args) {
        // 两种启动方式
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.run(args);
        SpringApplication.run(Application.class, args);
    }

}
