package com.sample.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @Author: zhengyi
 * @Date: 2019/12/17 9:28
 */
@Configuration
public class LifeCycleConfiguration {

    @Scope(SCOPE_PROTOTYPE)
    @Bean(initMethod = "init", destroyMethod = "destory")
    public LifeCycleInfo lifeCycleInfo() {
        return new LifeCycleInfo();
    }
}
