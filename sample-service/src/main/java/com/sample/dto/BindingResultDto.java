package com.sample.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * bindingResult使用dto
 *
 * @Author: zhengyi
 * @Date: 2019/11/27 10:11
 */
public class BindingResultDto {
    private String name;
    private String password;
    private Integer age;

    @NotEmpty(message = "用户名不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 5, max = 10, message = "密码长度为5-10位")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Min(value = 10, message = "年龄不能小于10")
    @Max(value = 30, message = "年龄不能大于30")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
