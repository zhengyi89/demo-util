package com.sample.spring.beanPostProcessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: zhengyi
 * @Date: 2019/12/18 9:36
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    /**
     * 初始化容器后置处理器，实例化、依赖注入完毕，init-method之前调用
     *
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof User){
            System.out.println("-------postProcess Before," + beanName );
            ((User) bean).setBeanName("5 mvp");
        }
        return bean;
    }

    /**
     * 实例化、依赖注入、初始化完毕时执行
     *
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof User){
            System.out.println("-------postProcess After," + beanName );
            ((User) bean).setBeanName("6 mvp");
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
