package com.sample.hession;
import com.sample.model.UserInfo;

/**
 * @Author: zhengyi
 * @Date: 2019/9/12 11:34
 */
public interface HelloService {

    String helloWorld(String message);

    UserInfo getMyInfo(UserInfo user);

}
