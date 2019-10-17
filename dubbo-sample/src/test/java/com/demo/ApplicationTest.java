package com.demo;

import com.demo.dubbo.Application;
import com.demo.dubbo.demo.action.AnnotationAction;
import com.demo.dubbo.demo.configuration.ConsumerConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        String hello = annotationAction.doSayHello("world");
    }
}
