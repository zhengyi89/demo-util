package com.test.h2;

import com.test.h2.dao.UserDao;
import com.test.h2.pojo.User;
import org.junit.Test;

import java.util.Date;

/**
 * @author zhengy
 * @date 18/8/15下午4:40
 */
public class UserTest {
    private UserDao dao = new UserDao();

    @Test
    public void testInsert(){
        User user=new User();
        user.setPassword("111116");
        user.setUserName("zhengy");
        dao.insert(user);
    }

    @Test
    public void testName(){
        User user = dao.getByName("zhengy");
        System.out.println("user createTime :"+user.getCreateTime());
        System.out.println(user.getUserId());
    }
}