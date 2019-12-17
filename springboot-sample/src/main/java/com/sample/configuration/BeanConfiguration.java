package com.sample.configuration;

import com.sample.spring.FactoryBeanExample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhengyi
 * @Date: 2019/12/17 9:28
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public FactoryBeanExample factoryBeanExample() {
        return new FactoryBeanExample();
    }
}
