
package com.sample;

import org.apache.commons.lang.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class StrSubstitutorTest {


    public static void main(String[] args) {

        Map map = new HashMap<>();
        String jsonStr = "{\"aa\":${aa},\"bb\":${ab},\"ca\":${cc}}";

        map.put("aa", "1");

        StrSubstitutor strSubstitutor = new StrSubstitutor(map);
        String formatJson = strSubstitutor.replace(jsonStr);

        System.out.println(formatJson);
    }
}
