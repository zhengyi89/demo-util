package com.test.constructs.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.omg.CORBA.portable.ApplicationException;

/** 
 * 采用动态代理封装事务 
 *  
 * @author liuzhengquan 
 *  
 */  
public class TransactionHandler implements InvocationHandler {  
  
    //要处理的对象，声明为Object类型是为了通用性  
    private Object targetObject;  
      
    //动态生成方法被处理过后的对象   
    public Object newProxyInstance(Object targetObject) {  
        this.targetObject = targetObject;  
        /** 
         * 参数1：类的加载器 
         * 参数2：确定继承类的接口 
         */  
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),  
                targetObject.getClass().getInterfaces(),   
                this);  
    }  
  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Connection conn = null;  
        Object ret = null;  
        try {  
            //取得Connection  
            conn = ConnectionManager.getConnection();  
            //System.out.println(method.getName());  
            /* 
             * 判断Manager层调用的什么方法，调用该方法时，自动开始事务 
             *注：此处DRP视频中有错误 
             */  
            if(method.getName().startsWith("addFlowCard") ||   
               method.getName().startsWith("delFlowCard") ||   
               method.getName().startsWith("modifyFlowCard") ||   
               method.getName().startsWith("findFlowCardList") ||   
               method.getName().startsWith("findClient") ||   
               method.getName().startsWith("findAimClient")   
               ){  
                System.out.println(method.getName());  
                // 手动开启事务  
                ConnectionManager.beginTransaction(conn);  
            }  
            //调用目标对象的业务逻辑方法  
            ret=method.invoke(targetObject, args);  
            if(!conn.getAutoCommit()){  
                //提交事务  
                ConnectionManager.commitTransaction(conn);  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
            //使用代理后，代理用InvocationTargetException包装了异常  
            if(e instanceof InvocationTargetException){  
                InvocationTargetException ete=(InvocationTargetException)e;  
                throw ete.getTargetException();  
            }  
            if(!conn.getAutoCommit()){  
                //回滚事务  
                ConnectionManager.rollbackTransaction(conn);  
            }  
            throw new ApplicationException("操作失败！", null);  
        }  
        finally{  
            //关闭事务，并删除连接  
            ConnectionManager.closeConnection();  
        }  
        return ret;  
    }  
  
}  

class ConnectionManager {
	static void closeConnection(){};

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void rollbackTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	public static void beginTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	public static void commitTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}
}
