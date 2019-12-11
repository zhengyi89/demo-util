package com.sample.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * application context 事件机制
 *
 * @Author: zhengyi
 * @Date: 2019/11/28 13:30
 */
@Component
public class ApplicationListenerSample implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * applicationContext初始化或刷新时，该事件发布
     *
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(contextRefreshedEvent);
        System.out.println("ApplicationListenerSample............................");
    }
}
