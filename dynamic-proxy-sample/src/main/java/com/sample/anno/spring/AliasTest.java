package com.sample.anno.spring;

import org.springframework.core.annotation.AnnotationUtils;

/**
 * 使用spring AnnotationUtils获取注解信息
 *
 * @Author: zhengyi
 * @Date: 2020/6/11 11:55
 */
@MyAnnotation(location = "location")
public class AliasTest {

    public void test() {
        MyAnnotation myAnnotation = AnnotationUtils.getAnnotation(this.getClass(), MyAnnotation.class);
        System.out.println("value:" + myAnnotation.value() + ";loation:" + myAnnotation.location());
    }

    public static void main(String[] args) {
        new AliasTest().test();
    }
}
