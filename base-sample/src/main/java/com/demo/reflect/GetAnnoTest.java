//package com.demo.reflect;
//
//import com.demo.anno.Cach;
//import com.demo.service.impl.UserInfoServiceImpl;
//import org.junit.Test;
//
//import java.lang.reflect.Method;
//
///**
// * 反射操作注解
// *
// * @author zhengy
// * @date: 2019年5月16日 下午4:25:00
// */
//public class GetAnnoTest {
//    @Test
//    public void testAnno() {
//        Class<UserInfoServiceImpl> clazz = UserInfoServiceImpl.class;
//        Class<Cach> anno = Cach.class;
//
//        // 通过反射判断类上是否加了指定的注解
//        if (clazz.isAnnotationPresent(anno)) {
//            // 通过反射获取注解实例
//            Cach annotation = (Cach) clazz.getAnnotation(anno);
//            // 打印注解信息
//            System.out.println(annotation.key());
//            System.out.println(annotation.bussName());
//            System.out.println(annotation.needLog());
//        }
//
//        // 通过反射获取类下面所有方法
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(anno)) {
//                // 通过反射获取注解实例
//                Cach annotation = (Cach) method.getAnnotation(anno);
//                // 打印注解信息
//                System.out.println(annotation.key());
//                System.out.println(annotation.bussName());
//                System.out.println(annotation.needLog());
//            }
//        }
//    }
//}
