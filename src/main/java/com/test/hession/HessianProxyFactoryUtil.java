package com.test.hession;

import com.caucho.hessian.client.HessianProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <获取客户端连接工厂对象>
 * <功能详细描述>
 * @author wzh
 * @version 2018-11-18 20:45
 * @see [相关类/方法] (可选)
 **/
public class HessianProxyFactoryUtil {

    private Logger log = LoggerFactory.getLogger(HessianProxyFactoryUtil.class);

    /**
     *  获取调用端对象
     * @param clazz 实体对象泛型
     * @param url 客户端url地址
     * @param <T>
     * @return 业务对象
     */
    public static <T> T getHessianClientBean(Class<T> clazz,String url) throws Exception
    {
        // 客户端连接工厂,这里只是做了最简单的实例化，还可以设置超时时间，密码等安全参数
        HessianProxyFactory factory = new HessianProxyFactory();

        return (T)factory.create(clazz,url);
    }

    //
    public static void main(String[] args) {

        // 服务器暴露出的地址
        String url = "http://localhost:8080/helloHessian.do";

        // 客户端接口，需与服务端对象一样 
        try {
            HelloService helloHessian = HessianProxyFactoryUtil.getHessianClientBean(HelloService.class,url);
            String msg =  helloHessian.helloWorld("你好");

            System.out.println(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}