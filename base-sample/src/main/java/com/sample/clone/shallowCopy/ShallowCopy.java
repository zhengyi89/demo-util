package com.sample.clone.shallowCopy;

/**
 * 浅拷贝
 *
 * @Author: zhengyi
 * @Date: 2020/9/17 15:31
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Subject subject = new Subject("yuwen");
        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("Lynn");
        studentA.setAge(20);

        Student studentB = (Student) studentA.clone();
        studentB.setName("Lily");
        studentB.setAge(18);

        Subject subjectB = studentB.getSubject();
        subjectB.setName("lishi");
        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }
}
