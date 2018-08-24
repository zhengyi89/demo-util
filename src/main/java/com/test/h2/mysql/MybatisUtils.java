package com.test.h2.mysql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


/**
 * @author zhengy
 * @date 18/8/15下午5:44
 */


public class MybatisUtils {
    public static SqlSessionFactory getFactory() {

        String resource = "mybatis.cof.xml";

        //加载mybatis 的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisUtils.class.getClassLoader().getResourceAsStream(resource);

        //构建sqlSession 的工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory;
    }
}