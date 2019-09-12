package com.test.dubbo.demo;

import com.test.dubbo.demo.action.AnnotationAction;
import com.test.dubbo.demo.configuration.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhengyi
 * @Date: 2019/8/23 9:15
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        String hello = annotationAction.doSayHello("world");
    }
}
