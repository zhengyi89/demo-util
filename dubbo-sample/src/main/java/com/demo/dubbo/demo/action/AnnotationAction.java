package com.demo.dubbo.demo.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.dubbo.demo.service.AnnotationService;

/**
 * @Author: zhengyi
 * @Date: 2019/8/23 9:11
 */
public class AnnotationAction {
    @Reference
    private AnnotationService annotationService;

    public String doSayHello(String name) {
        return annotationService.sayHello(name);
    }
}
