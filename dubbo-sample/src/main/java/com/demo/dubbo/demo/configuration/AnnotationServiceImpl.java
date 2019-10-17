package com.demo.dubbo.demo.configuration;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.dubbo.demo.service.AnnotationService;

/**
 * @Author: zhengyi
 * @Date: 2019/8/23 9:00
 */
@Service
public class AnnotationServiceImpl implements AnnotationService {
    @Override
    public String sayHello(String name) {
        return "annotation: hello, " + name;
    }
}
