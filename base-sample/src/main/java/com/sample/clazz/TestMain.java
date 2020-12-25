package com.sample.clazz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhengyi
 * @Date: 2020/12/2 18:13
 */
public class TestMain {
    static Map map = new HashMap<>();

    static {
        map.put("11", "11");
        map.put("12", "12");
    }

    public void dotest() {
        Map m = map;
        m.put("cc", "dd");
        System.out.println(m == map);
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(m));
    }

    public static void main(String[] args) {
        new TestMain().dotest();
    }
}
