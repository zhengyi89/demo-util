package com.sample.collection;

import org.junit.Test;

import java.util.Arrays;

/**
 * java.util.Arrays 常用方法
 *
 * @Author: zhengyi
 * @Date: 2019/11/25 9:56
 */
public class ArraysSample {

    int[] a = {11, 22, 13, 5, 7, 2};

    /**
     * 数组复制
     */
    @Test
    public void testCopyOfRange() {

        int[] b = Arrays.copyOfRange(a, 0, 4);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 排序
     */
    @Test
    public void testSort() {
        System.out.println("排序之前 :");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("排序之后:");
        System.out.println(Arrays.toString(a));
    }

    /**
     * 搜索，使用搜索前要先进行排序
     */
    @Test
    public void testSearch() {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //使用binarySearch之前，必须先使用sort进行排序
        System.out.println("数字 22出现的位置:" + Arrays.binarySearch(a, 7));
    }

}
