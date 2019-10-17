package com.demo.mq.rabbitmq;
import java.util.Random;  
import java.util.UUID;  
  
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
  
public class EmitLogDirect  
{  
  
    private static final String EXCHANGE_NAME = "ex_logs_direct";  
    private static final String[] SEVERITIES = { "info", "warning", "error" };  
  
    public static void main(String[] argv) throws java.io.IOException, TimeoutException  
    {  
        // �������Ӻ�Ƶ��  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
        // ����ת����������  
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");  
  
        //����6����Ϣ  
        for (int i = 0; i < 600; i++)  
        {  
            String severity = getSeverity();  
            String message = severity + "_log :" + UUID.randomUUID().toString();  
            // ������Ϣ��ת������ָ��routingkey  
            channel.basicPublish(EXCHANGE_NAME, severity, null, message  
                    .getBytes());  
            System.out.println(" [x] Sent '" + message + "'");  
        }  
  
        channel.close();  
        connection.close();  
    }  
  
    /** 
     * �������һ����־���� 
     *  
     * @return 
     */  
    private static String getSeverity()  
    {  
        Random random = new Random();  
        int ranVal = random.nextInt(3);  
        return SEVERITIES[ranVal];  
    }  
}  

