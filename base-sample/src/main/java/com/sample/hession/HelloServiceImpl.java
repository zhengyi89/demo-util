package com.sample.hession;

import com.caucho.hessian.server.HessianServlet;
import com.sample.model.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @Author: zhengyi
 * @Date: 2019/9/12 11:35
 */
@Service("sayHelloHessian")
public class HelloServiceImpl extends HessianServlet implements HelloService {

    private static final long serialVersionUID = -3537274030227675984L;

    @Override
    public String helloWorld(String message) {
        return "Hello, " + message;
    }

    @Override
    public UserInfo getMyInfo(UserInfo user) {
        if (null == user) {
            return new UserInfo();
        }

        user.setMobile("15111111111");
        return user;
    }


}

