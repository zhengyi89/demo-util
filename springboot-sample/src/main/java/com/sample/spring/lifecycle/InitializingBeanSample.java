package com.sample.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * InitializingBean接口为bean提供了初始化方式，它只包含afterPropertiesSet方法，
 * 凡是继承该接口的类，初始化bean时都会执行该方法
 * <p>
 * DisposableBean接口为bean提供了销毁方法
 *
 * @Author: zhengyi
 * @Date: 2019/10/29 11:11
 */
@Component
public class InitializingBeanSample implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean ........");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitializingBean destory ...");
    }
}
