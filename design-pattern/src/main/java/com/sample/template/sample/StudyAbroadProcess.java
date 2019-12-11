package com.sample.template.sample;

/**
 * 模板方法实现-出国留学（美国留学）
 *
 * @Author: zhengyi
 * @Date: 2019/10/16 17:51
 */
public class StudyAbroadProcess {
    public static void main(String[] args) {
        StudyAbroad tm = new StudyInAmerica();
        tm.TemplateMethod();
    }
}
