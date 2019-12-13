package com.sample.ognl.model;

/**
 * @Author: zhengyi
 * @Date: 2019/12/13 9:48
 */
public class Address {
    private String port;
    private String detail;

    public Address(String port, String detail) {
        this.port = port;
        this.detail = detail;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
