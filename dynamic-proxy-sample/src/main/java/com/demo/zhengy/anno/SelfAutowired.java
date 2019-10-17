package com.demo.zhengy.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
// 注解位置－类
@Retention(RetentionPolicy.RUNTIME)
// 运行时机－运行时
@Documented
// javadoc
public @interface SelfAutowired {
	String value() default "";
}
