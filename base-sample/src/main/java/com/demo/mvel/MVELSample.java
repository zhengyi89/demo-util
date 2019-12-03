package com.demo.mvel;

import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

/**
 * MVEL是一种基于java语法的表达式语言，为java提供更便捷灵活的动态性
 *
 * @Author: zhengyi
 * @Date: 2019/12/3 15:13
 */
public class MVELSample {

    public static void main(String[] args) {
        Map vars = new HashMap();
        vars.put("foobar", new Integer(100));

        Boolean result = (Boolean) MVEL.eval("foobar>99", vars);
        if (result) {
            System.out.println("It works!");
        }



    }
}
