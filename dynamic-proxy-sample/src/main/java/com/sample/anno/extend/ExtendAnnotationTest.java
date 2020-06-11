package com.sample.anno.extend;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * @Author: zhengyi
 * @Date: 2020/6/11 13:37
 */
public class ExtendAnnotationTest {
    @Test
    public void test() {
        /*
         * 不能再使用AnnotationUtils获取注释对象
         */
        AnnotaionBase annotaionBase = AnnotatedElementUtils.findMergedAnnotation(ExtendClass.class, AnnotaionBase.class);
        System.out.println("------" + annotaionBase.value());
        Assert.assertTrue("faild", annotaionBase.value().equals("extendValue"));
    }
}