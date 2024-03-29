package com.sample.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional类是Java8为了解决null值判断问题
 *
 * @Author: zhengyi
 * @Date: 2020/10/21 14:38
 */
public class OptionalSample {
//    OptionalSample optionalSample = new OptionalSample();
//    Integer value1 = null;
//    Integer value2 = new Integer(10);
//    // Optional.ofNullable - 允许传递为 null 参数
//    Optional<Integer> a = Optional.ofNullable(value1);
//    // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
//    Optional<Integer> b = Optional.of(value2);
//        System.out.println(optionalSample.sum(a, b));
//} public static void main(String args[]) {


    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent - 判断值是否存在
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));
        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }


    public static void main(String[] args) {
        Integer i = 11;
        List<Integer> list = new ArrayList<>(Arrays.asList(11,22));
        Optional.ofNullable(list).ifPresent(x->{
            System.out.println("---"+i);
        });
        System.out.println(i);
    }
}
