
package com.sample.collection;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SetSample {

    static String[] atp = {"a", "b",
            "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
            "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};


    @Test
    public void dotest() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        Set<String> set2 = new HashSet<>();
        set2.add("c");
        set2.add("d");
        set2.add("b");

        set.retainAll(set2);
        System.out.println(JSON.toJSONString(set));
    }


    @Test
    public void test() {
        Set<String> planIdSet = Arrays.asList(atp).stream().collect(Collectors.toSet());

        for (String s : planIdSet) {
            if (s.equals("a")){
                planIdSet.remove(s);
            }
        }
        System.out.println(JSON.toJSONString(planIdSet));
    }
}
