package com.sample.iterator;

/**
 * 所要便利的集合的接口。实现了该接口的类将成为一个可以保存多个元素的集合，类似数组。
 *
 * @Author: zhengyi
 * @Date: 2020/9/16 14:28
 */
public interface Aggregate{
    Iterator iterator();
}
