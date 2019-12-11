package com.sample.util;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhengyi
 * @Date: 2019/12/4 9:26
 */
public class ArraysSample {
    public static void main(String[] args) {
        String[] str = new String[]{"you", "wu"};
        List list = Arrays.asList(str);
//        list.add("yangguanbao");
        str[0] = "gujin";
        System.out.println(list);

    }
}
