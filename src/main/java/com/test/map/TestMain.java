package com.test.map;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.test.velocity.User;

public class TestMain {
	
	@Test
	public void test() throws Exception{
		User uset = new User("郑义", "14", "123556");
		Map<String,Object> map = bean2map(uset);
		System.out.println(map.get("name"));
	}
	

    /**
     * JavaBean转换为Map
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public static Map<String, Object> bean2map(Object bean) throws Exception {
        Map<String, Object> map = new HashMap<>();
        //获取指定类（Person）的BeanInfo 对象
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(), Object.class);
        //获取所有的属性描述器
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            String key = pd.getName();
            Method getter = pd.getReadMethod();
            Object value = getter.invoke(bean);
            map.put(key, value);
        }
        return map;
    }
}
