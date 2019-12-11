package com.sample.mq.rabbitmq;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
import com.rabbitmq.client.QueueingConsumer;  
  
/*
 * ����-����  ���ն� 1
 */
public class ReceiveLogsToSave  
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
  
            print2File(message);  
        }  
  
    }  
  
    private static void print2File(String msg)  
    {  
        try  
        {  
            String dir = ReceiveLogsToSave.class.getClassLoader().getResource("").getPath();  
            String logFileName = new SimpleDateFormat("yyyy-MM-dd")  
                    .format(new Date());  
            File file = new File("d:/"+logFileName+".txt");  
            FileOutputStream fos = new FileOutputStream(file, true);  
            fos.write((msg + "\r\n").getBytes());  
            fos.flush();  
            fos.close();  
        } catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
        } catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
    }  
}  
