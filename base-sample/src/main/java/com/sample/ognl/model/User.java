package com.sample.ognl.model;

/**
 * @Author: zhengyi
 * @Date: 2019/12/13 9:47
 */
public class User {
    private String name;
    private Integer age;
    private Address address;

    public User(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
