package com.sample.spring.customerApplicationEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义监听
 *
 * @Author: zhengyi
 * @Date: 2019/12/3 11:27
 */

public class EmailNotifier implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof EmailEvent) {

            EmailEvent emailEvent = (EmailEvent) event;

            System.out.println("邮件地址：" + emailEvent.getAddress());

            System.out.println("邮件内容：" + emailEvent.getText());

        } else {

            System.out.println("容器本身事件：" + event);

        }

    }

}
