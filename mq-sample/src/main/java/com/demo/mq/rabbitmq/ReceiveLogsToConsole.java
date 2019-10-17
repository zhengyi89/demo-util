package com.demo.mq.rabbitmq;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
import com.rabbitmq.client.QueueingConsumer;  
  
/*
 * ����-����  ���ն� 2
 */
public class ReceiveLogsToConsole  
{  
    private final static String EXCHANGE_NAME = "ex_log";  
  
    public static void main(String[] argv) throws java.io.IOException,  
            java.lang.InterruptedException, TimeoutException  
    {  
        // �������Ӻ�Ƶ��  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
  
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");  
        // ����һ���ǳ־õġ�Ψһ�����Զ�ɾ���Ķ���  
        String queueName = channel.queueDeclare().getQueue();  
        // Ϊת����ָ�����У�����binding  
        channel.queueBind(queueName, EXCHANGE_NAME, "");  
  
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");  
  
        QueueingConsumer consumer = new QueueingConsumer(channel);  
        // ָ�������ߣ��ڶ�������Ϊ�Զ�Ӧ�������ֶ�Ӧ��  
        channel.basicConsume(queueName, true, consumer);  
  
        while (true)  
        {  
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
            String message = new String(delivery.getBody());  
            System.out.println(" [x] Received '" + message + "'");  
  
        }  
  
    }  
  
}  
