package com.sample.ognl;

import com.sample.ognl.model.Address;
import com.sample.ognl.model.User;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用ognl表达式获取对象属性值
 * <p>
 * ognl包含三要素：1.表达式 2.root对象 3.上下文环境
 *
 * @Author: zhengyi
 * @Date: 2019/12/13 9:46
 */
public class OgnlSample {
    private Address address;
    private User user;

    @Before
    public void doBefore() {
        address = new Address("110003", "大连市");
        user = new User("zhengy", 12, address);
    }

    /**
     * 对root对象的访问
     * <p>
     * root对象可以理解为ognl的操作对象，我们需要指定这个表达式针对的是哪个具体的对象。而这个具体的对象就是Root对象
     */
    @Test
    public void testOgnlRoot() throws OgnlException {
        System.out.println(Ognl.getValue("name", user));
        System.out.println(Ognl.getValue("address", user));
        System.out.println(Ognl.getValue("address.port", user));

    }


    /**
     * 对上下文对象的访问
     * <p>
     * 访问上下文环境的参数，表达式前面需要加上‘#’，用来区别root对象的访问
     */
    @Test
    public void testOgnlContext() throws OgnlException {

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("init", "hello");
        context.put("user", user);

        System.out.println(Ognl.getValue("#init", context, user));
        System.out.println(Ognl.getValue("#user.name", context, user));
        System.out.println(Ognl.getValue("name", context, user));

    }


    public final static String ONE = "one";

    public static String getString() {
        return "string";
    }

    /**
     * 对静态变量/方法的访问,格式如@[class]@[field/method()]
     */
    @Test
    public void testOgnlStaticAccess() throws OgnlException {
        Object object = Ognl.getValue("@com.sample.ognl.OgnlSample@ONE", null);
        Object object2 = Ognl.getValue("@com.sample.ognl.OgnlSample@getString()", null);
        System.out.println(object);
        System.out.println(object2);
    }


    /**
     * 调用方法
     */
    @Test
    public void testOgnl3() throws OgnlException {
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("name", "rcx");
        context.put("password", "password");
        System.out.println(Ognl.getValue("getName()", context, user));
        Ognl.getValue("setName(#name)", context, user);
        System.out.println(Ognl.getValue("getName()", context, user));
    }


    /**
     * 访问数组和集合
     * 从以下代码还可以看出ognl表达式支持简单的运算
     *
     * @throws OgnlException
     */
    @Test
    public void testOgnl4() throws OgnlException {
        Map<String, Object> context = new HashMap<String, Object>();
        String[] strings = {"aa", "bb"};
        ArrayList<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        context.put("list", list);
        context.put("strings", strings);
        context.put("map", map);

        System.out.println(Ognl.getValue("#strings[0]", context, user));
        System.out.println(Ognl.getValue("#list[0]", context, user));
        System.out.println(Ognl.getValue("#list[0 + 1]", context, user));
        System.out.println(Ognl.getValue("#map['key1']", context, user));
        System.out.println(Ognl.getValue("#map['key' + '2']", context, user));
    }

}
