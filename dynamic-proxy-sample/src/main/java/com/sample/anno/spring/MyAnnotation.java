package com.sample.anno.spring;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author: zhengyi
 * @Date: 2020/6/11 11:55
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface MyAnnotation {
    /*
     * AliasFor意思是，注解的属性可以互相为别名使用
     */
    @AliasFor(attribute = "location")
    String value() default "";

    @AliasFor(attribute = "value")
    String location() default "";
}