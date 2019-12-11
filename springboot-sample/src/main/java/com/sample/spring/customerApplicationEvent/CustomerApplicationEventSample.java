package com.sample.spring.customerApplicationEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zhengyi
 * @Date: 2019/12/3 11:29
 */

public class CustomerApplicationEventSample {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.yml");
        //创建一个ApplicationEvent对象
        EmailEvent event = new EmailEvent("hello", "abc@163.com", "This is a test");
        //主动触发该事件
        context.publishEvent(event);
    }

}
