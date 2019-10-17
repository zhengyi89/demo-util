package com.demo.mq.rabbitmq;
import java.io.IOException;  
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;

/*
 * ��ϢӦ��/�־û�
 */
public class NewTask  
{  
    //��������  
    private final static String QUEUE_NAME = "workqueue";  
  
    public static void main(String[] args) throws IOException, TimeoutException  
    {  
        //�������Ӻ�Ƶ��  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
        //���г־û�
        boolean durable = false;
        //��������  
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);  
        //����10����Ϣ����������Ϣ���渽��1-10����  
        for (int i = 0; i < 10; i++)  
        {  
            String dots = "";  
            for (int j = 0; j <= i; j++)  
            {  
                dots += ".";  
            }  
            String message = "helloworld" + dots+dots.length();  
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());  
            //��Ϣ�־û�
//            channel.basicPublish("", "task_queue",MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");  
        }  
        //�ر�Ƶ������Դ  
        channel.close();  
        connection.close();  
  
    }  
  
  
}  

