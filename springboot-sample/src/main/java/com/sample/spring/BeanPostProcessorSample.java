package com.sample.spring;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: zhengyi
 * @Date: 2019/12/18 9:36
 */
@Component
public class BeanPostProcessorSample implements BeanPostProcessor {

    /**
     * 初始化容器后置处理器，init-method之前调用
     *
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        System.out.println("postProcess Before,"+beanName+"--"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println("postProcess After,"+beanName+"--"+bean);
        return bean;
    }

}
