package com.test.h2.dao;

import com.alibaba.fastjson.JSON;
import com.test.h2.HibernateUtil;
import com.test.h2.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

/**
 * @author zhengy
 * @date 18/8/15下午4:17
 */
public class UserDao {
    public boolean insert(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tas = session.beginTransaction();
        try {
            user.setCreateTime(new Date());
            session.save(user);
            tas.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tas.rollback();
            return false;
        }
        return true;
    }

    public User getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tas = session.beginTransaction();
        User user = null;
        try {
            Query query = session.createQuery("from User t where t.username=:name");
            query.setString("name", name);
            user = (User) query.uniqueResult();
            System.out.println("查询结果为："+ JSON.toJSONString(user));
            tas.commit();
        } catch (Exception e) {
            tas.rollback();
            e.printStackTrace();
        }

        return user;
    }


}