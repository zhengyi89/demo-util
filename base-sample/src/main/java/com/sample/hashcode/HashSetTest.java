package com.sample.hashcode;

import java.util.HashSet;

/**
 * （1）同一个对象多次调用hashCode()方法应该返回相同的值；
 * （2）当两个对象通过equals()方法比较返回true时，这两个对象的hashCode()应该返回相等的（int）值；
 * （3）对象中用作equals()方法比较标准的Filed(成员变量（类属性）)，都应该用来计算hashCode值。
 *
 * @Author: zhengyi
 * @Date: 2020/6/12 16:15
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new A());
        hashSet.add(new A());
        hashSet.add(new B());
        hashSet.add(new B());
        hashSet.add(new C());
        hashSet.add(new C());
        for (Object hs : hashSet) {
            System.out.println(hs);
        }
        //HashSet重写了toString()方法
        System.out.println(hashSet);
    }
}
