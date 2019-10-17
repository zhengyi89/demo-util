package com.demo.constructs.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.omg.CORBA.portable.ApplicationException;

/** 
 * ���ö�̬�����װ���� 
 *  
 * @author liuzhengquan 
 *  
 */  
public class TransactionHandler implements InvocationHandler {  
  
    //Ҫ����Ķ�������ΪObject������Ϊ��ͨ����  
    private Object targetObject;  
      
    //��̬���ɷ������������Ķ���   
    public Object newProxyInstance(Object targetObject) {  
        this.targetObject = targetObject;  
        /** 
         * ����1����ļ����� 
         * ����2��ȷ���̳���Ľӿ� 
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
            //ȡ��Connection  
            conn = ConnectionManager.getConnection();  
            //System.out.println(method.getName());  
            /* 
             * �ж�Manager����õ�ʲô���������ø÷���ʱ���Զ���ʼ���� 
             *ע���˴�DRP��Ƶ���д��� 
             */  
            if(method.getName().startsWith("addFlowCard") ||   
               method.getName().startsWith("delFlowCard") ||   
               method.getName().startsWith("modifyFlowCard") ||   
               method.getName().startsWith("findFlowCardList") ||   
               method.getName().startsWith("findClient") ||   
               method.getName().startsWith("findAimClient")   
               ){  
                System.out.println(method.getName());  
                // �ֶ���������  
                ConnectionManager.beginTransaction(conn);  
            }  
            //����Ŀ������ҵ���߼�����  
            ret=method.invoke(targetObject, args);  
            if(!conn.getAutoCommit()){  
                //�ύ����  
                ConnectionManager.commitTransaction(conn);  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
            //ʹ�ô���󣬴�����InvocationTargetException��װ���쳣  
            if(e instanceof InvocationTargetException){  
                InvocationTargetException ete=(InvocationTargetException)e;  
                throw ete.getTargetException();  
            }  
            if(!conn.getAutoCommit()){  
                //�ع�����  
                ConnectionManager.rollbackTransaction(conn);  
            }  
            throw new ApplicationException("����ʧ�ܣ�", null);  
        }  
        finally{  
            //�ر����񣬲�ɾ������  
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
