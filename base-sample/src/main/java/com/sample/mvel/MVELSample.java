package com.sample.mvel;

import com.sample.model.UserInfo;
import org.junit.Test;
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

    /**
     * 条件判断
     */
    @Test
    public void test() {
        String expression = "foobar > 99";
        Map vars = new HashMap(1);
        vars.put("foobar", 100);
        Boolean result = (Boolean) MVEL.eval(expression, vars);
        System.out.println("mvel result is :" + result);
    }

    /**
     * 空判断
     */
    @Test
    public void test1() {
        String expression = "a == empty || b == empty";
        Map vars = new HashMap();
        vars.put("a", "aa");
        vars.put("b", "");
        Boolean result = (Boolean) MVEL.eval(expression, vars);
        System.out.println("mvel result is :" + result);
    }

    /**
     * 设置对象属性
     */
    @Test
    public void test2() {
        UserInfo user = new UserInfo();
        user.setUsername("1234");
        String expression = "user.username = '123'";
        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("user", user);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println("mvel result is :" + user.getUsername());
    }
}
