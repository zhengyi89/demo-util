package com.sample.spring;

import com.sample.configuration.BeanConfiguration;
import com.sample.model.UserInfo;
import com.sample.spring.lifecycle.LifeCycleConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhengyi
 * @Date: 2019/12/17 9:39
 */
public class AnnototionConfigApplicationTest {

    /**
     *
     */
    @Test
    public void beanInjectTest() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("---------------===" + beanDefinitionName);
        }

        System.out.println(applicationContext.getBean("factoryBeanExample").getClass());
        UserInfo userInfo = (UserInfo) applicationContext.getBean("factoryBeanExample");
        System.out.println("===========" + userInfo.getUsername());
    }


    /**
     * spring bean生命周期
     */
    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        /*
         * spring使用单例模式，初始化时加载；使用多例，获取对象时加载
         */
        Object o1 = applicationContext.getBean("lifeCycleInfo");
        Object o2 = applicationContext.getBean("lifeCycleInfo");
        System.out.println("------------------");
        System.out.println(o1 == o2);
        applicationContext.close();
    }
}
