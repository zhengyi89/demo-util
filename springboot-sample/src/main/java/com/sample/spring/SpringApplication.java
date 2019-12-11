package com.sample.spring;

import com.sample.controller.TestController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@MapperScan("com.demo.mapper")
public class SpringApplication {


    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);

        TestController testController = ApplicationContextUtil.getBean(TestController.class);
        String s = testController.test("lxy");
        System.out.println("-----------------------"+s);

        TestController testController1 = ApplicationContextUtil.getBean("testController",TestController.class);
        String s1 = testController1.test("lxy");
        System.out.println("-----------------------"+s1);

    }

}
