package com.demo.mq.rabbitmq;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
  
public class Send {  
    //��������  
    private final static String QUEUE_NAME = "hello";  
  
    public static void main(String[] argv) throws java.io.IOException, TimeoutException {  
        /** 
         * �����������ӵ�MabbitMQ 
         */  
        ConnectionFactory factory = new ConnectionFactory();  
        //����MabbitMQ��������ip����������  
        factory.setHost("localhost");  
        //����һ������  
        Connection connection = factory.newConnection();  
        //����һ��Ƶ��  
        Channel channel = connection.createChannel();  
        //ָ��һ������  
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);  
        //���͵���Ϣ  
        String message = "hello world!";  
        //�������з���һ����Ϣ  
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());  
        System.out.println(" [x] Sent '" + message + "'");  
        //�ر�Ƶ��������  
        channel.close();  
        connection.close();  
     }  
}  
