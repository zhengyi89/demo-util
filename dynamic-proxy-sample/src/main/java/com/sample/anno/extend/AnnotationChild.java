package com.sample.anno.extend;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 编写子注解，其中子注解使用元注解@AnnotaionBase
 *
 * @Author: zhengyi
 * @Date: 2020/6/11 13:38
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AnnotaionBase
public @interface AnnotationChild {
    @AliasFor(annotation = AnnotaionBase.class, attribute = "value")
    String extendValue() default "";

}
