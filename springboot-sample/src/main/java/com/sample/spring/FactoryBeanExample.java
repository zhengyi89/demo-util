package com.sample.spring;

import com.sample.model.UserInfo;
import org.springframework.beans.factory.FactoryBean;

/**
 * 继承factoryBean,装载对象到spring容器
 *
 * @Author: zhengyi
 * @Date: 2019/12/17 9:23
 */
public class FactoryBeanExample implements FactoryBean<UserInfo> {
    @Override
    public UserInfo getObject() throws Exception {
        return new UserInfo();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
