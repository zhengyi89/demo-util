package com.sample.spring;

import com.sample.configuration.BeanConfiguration;
import com.sample.model.UserInfo;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 *
 * @Author: zhengyi
 * @Date: 2019/12/17 9:39
 */
public class AnnototionConfigSpringContext {
    @Test
    public void beanDependiceTest(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("---------------==="+beanDefinitionName);
        }

        System.out.println(applicationContext.getBean("factoryBeanExample").getClass());
        UserInfo userInfo = (UserInfo) applicationContext.getBean("factoryBeanExample");
        System.out.println("==========="+userInfo.getUsername());
    }
}
