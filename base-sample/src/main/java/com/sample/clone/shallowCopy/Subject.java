package com.sample.clone.shallowCopy;

/**
 * @Author: zhengyi
 * @Date: 2020/9/17 15:31
 */
public class Subject {

    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Subject: " + this.hashCode() + ",name:" + name + "]";
    }
}
