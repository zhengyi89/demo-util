package com.sample.mq.rabbitmq;
import java.io.IOException;  
import java.util.Date;  
  
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
  
/*
 * ����-����
 */
public class EmitLog {  
    private final static String EXCHANGE_NAME = "ex_log";  
  
    public static void main(String[] args) throws IOException, TimeoutException  {  
        // �������Ӻ�Ƶ��  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
        // ����ת����������  
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout" );  
          
        String message = new Date().toLocaleString()+" : log something";  
        // ��ת�����Ϸ�����Ϣ  
        channel.basicPublish(EXCHANGE_NAME, "aca", null, message.getBytes());  
  
        System.out.println(" [x] Sent '" + message + "'");  
  
        channel.close();  
        connection.close();  
  
    }  
  
}  
