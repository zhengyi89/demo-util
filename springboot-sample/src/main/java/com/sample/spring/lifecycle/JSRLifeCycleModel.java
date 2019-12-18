package com.sample.spring.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * JSR250规范定义的@Post和进行初始化和注销
 *
 * @Author: zhengyi
 * @Date: 2019/12/18 9:20
 */
@Component
public class JSRLifeCycleModel {

    public JSRLifeCycleModel(){
        System.out.println("JSR LifeCycle construct..");
    }

    @PostConstruct
    public void init(){
        System.out.println("JSR LifeCycle init..");
    }

    @PreDestroy
    public void destory(){
        System.out.println("JSR LifeCycle destory..");
    }
}
