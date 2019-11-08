package com.demo.controller;

import com.demo.anno.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: zhengyi
 * @Date: 2019/11/1 16:04
 */
public class TestController {


    @GetMapping(value = "/users")
    public PageInfo<User> getUsers() {
        PageHelper.startPage(1, 10);
        List<User> users = null;
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }
}
