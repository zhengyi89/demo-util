package com.sample.anno;

import java.lang.reflect.Method;

public class Test {
    @CustomerAnno(priority = CustomerAnno.Priority.MEDIUM, author = "Yashwant", status = CustomerAnno.Status.STARTED,
            name = "zhangsan", value = "bbb")
    public void incompleteMethod1() {
        //Some business logic is written
        //But it’s not complete yet
    }

    @CustomerAnno("aa")
    public void dotest() {

    }

    public static void main(String[] args) {
        Class testClass = Test.class;

        for (Method method : testClass.getMethods()) {
            // 使用spring工具类获取注解对象
//            CustomerAnno todoAnnotation = AnnotationUtils.getAnnotation(method, CustomerAnno.class);
            // jdk反射获取注解对象
            CustomerAnno todoAnnotation = method.getAnnotation(CustomerAnno.class);
            if (todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
                System.out.println(" value : " + todoAnnotation.value());
                System.out.println(" name : " + todoAnnotation.name());
            }
        }

    }

}

