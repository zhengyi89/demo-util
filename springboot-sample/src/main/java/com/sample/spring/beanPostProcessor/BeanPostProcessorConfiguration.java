package com.sample.spring.beanPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhengyi
 * @Date: 2020/10/29 16:33
 */
@Configuration
public class BeanPostProcessorConfiguration {

    @Bean
    public User getUser() {
        User user = new User();
        user.setName("kobe bryant");
        return user;
    }
}
