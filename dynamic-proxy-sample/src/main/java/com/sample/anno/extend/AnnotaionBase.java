package com.sample.anno.extend;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 编写元注解
 *
 * @Author: zhengyi
 * @Date: 2020/6/11 13:38
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnotaionBase {
    String value() default "";
}