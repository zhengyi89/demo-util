package com.test.hession;

import com.test.bean.UserInfo;

/**
 * @Author: zhengyi
 * @Date: 2019/9/12 11:34
 */
public interface HelloService {

    public String helloWorld(String message);

    public UserInfo getMyInfo(UserInfo user);

}
