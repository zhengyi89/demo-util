package com.sample.collection;

import com.sample.model.UserInfo;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类型转换
 *
 * @Author: zhengyi
 * @Date: 2019/10/28 16:44
 */
public class ConvertCenter {
    @Test
    public void bean2MapTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setMobile("15141186256");
        userInfo.setEmail("zy575100105@163.com");
        Map<String, Object> map = bean2map(userInfo);
        System.out.println(map.entrySet());
        String[] strArray = new String[12];
        map.keySet().toArray(strArray);
        System.out.println(Arrays.toString(strArray));
    }


    /**
     * JavaBean转换为Map
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public static Map<String, Object> bean2map(Object bean) {
        Map<String, Object> map = new HashMap<>();
        // 获取指定类（Person）的BeanInfo 对象
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(bean.getClass(), Object.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        // 获取所有的属性描述器
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            String key = pd.getName();
            Method getter = pd.getReadMethod();
            Object value = null;
            try {
                value = getter.invoke(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        }
        return map;
    }
}
