package com.sample.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * InitializingBean接口为bean提供了初始化方式，它只包含afterPropertiesSet方法，
 * 凡是继承该接口的类，初始化bean时都会执行该方法
 *
 * @Author: zhengyi
 * @Date: 2019/10/29 11:11
 */
//@Component
public class InitializingBeanSample implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("--------------------");
        System.out.println("InitializingBean execute....");
    }
}
