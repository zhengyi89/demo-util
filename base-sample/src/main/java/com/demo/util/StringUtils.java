package com.demo.util;

import org.junit.Test;

public class StringUtils {

    /**
     * 将Unicode编码转换为汉字
     *
     * @param utfString
     * @return
     */
    public static String convert(String utfString) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while ((i = utfString.indexOf("\\u", pos)) != -1) {
            sb.append(utfString.substring(pos, i));
            if (i + 5 < utfString.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
            }
        }

        if (pos > 0) {
            sb.append(utfString.substring(pos));
            return sb.toString();
        } else {
            return utfString;
        }

    }

    // 首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    @Test
    public void test() {
        String s = "{\"result\":\"ok\",\"total\":\"11\",\"data\":\"[{\"id\":\"812\",\"type\":\"2\",\"attr\":\"0\",\"title\":\"\\u793c\\u54c1\\u52382";
        System.out.println(convert(s));
    }

}
