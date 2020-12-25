package com.sample.spring.beanPostProcessor;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: zhengyi
 * @Date: 2019/12/12 14:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.sample.spring.beanPostProcessor")
public class BeanPostProcessorTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanPostProcessorConfiguration.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("---------------" + beanDefinitionName);
        }

        User user = applicationContext.getBean(User.class);
        System.out.println(JSON.toJSONString(user));
    }
}
