package com.test.dubbo.demo.configuration;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zhengyi
 * @Date: 2019/8/23 9:13
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.test.dubbo.demo.action")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan(value = {"com.test.dubbo.demo"})
public class ConsumerConfiguration {

}