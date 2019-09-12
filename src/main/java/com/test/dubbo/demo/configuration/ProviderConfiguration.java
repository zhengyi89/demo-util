package com.test.dubbo.demo.configuration;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zhengyi
 * @Date: 2019/8/23 9:03
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.test.dubbo.demo.service.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderConfiguration {

}