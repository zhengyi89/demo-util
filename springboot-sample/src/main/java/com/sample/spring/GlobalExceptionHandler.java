package com.sample.spring;

/**
 * @Author: zhengyi
 * @Date: 2020/11/3 16:39
 */

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void exception(Exception e) {
        System.out.println("---------start---------------");
        e.printStackTrace();
        System.out.println("----------end--------------");
    }
}
