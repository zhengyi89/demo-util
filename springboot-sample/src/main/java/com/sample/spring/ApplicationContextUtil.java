package com.sample.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 实现ApplicationContextAware接口，会在加载spring配置文件时，获取applicationContext，
 * 并调用ApplicationContextAware中的setApplicationContext方法
 *
 * @Author: zhengyi
 * @Date: 2019/12/3 11:48
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext正在初始化,application:" + applicationContext);
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            System.out.println("applicationContext是空的");
        } else {
            System.out.println("applicationContext不是空的");
        }
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String className, Class<T> clazz) {
        if (applicationContext == null) {
            System.out.println("applicationContext是空的");
        } else {
            System.out.println("applicationContext不是空的");
        }
        return applicationContext.getBean(className, clazz);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}


























