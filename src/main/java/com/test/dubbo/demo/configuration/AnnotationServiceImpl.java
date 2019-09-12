package com.test.dubbo.demo.configuration;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.dubbo.demo.service.AnnotationService;

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
