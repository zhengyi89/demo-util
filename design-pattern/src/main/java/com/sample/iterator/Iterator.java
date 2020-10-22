package com.sample.iterator;

/**
 * 作用为遍历集合中元素，相当于循环语句中的循环变量（for(int i =0 ;i<arr.lenth;i++）,具体实现一个顺序遍历的迭代器。
 *
 * @Author: zhengyi
 * @Date: 2020/9/16 14:29
 */
public interface Iterator {
    boolean hasNext();
    Object next();
}
