package com.sample.anno;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface CustomerAnno {
    enum Priority {LOW, MEDIUM, HIGH}

    enum Status {STARTED, NOT_STARTED}

    String author() default "Yash";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;

    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";
}


