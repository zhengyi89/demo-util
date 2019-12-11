package com.sample.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.util.concurrent.TimeoutException;

public class Work {
    //��������  
    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] argv) throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {
        //���ֲ�ͬ�������̵����  
        int hashCode = Work.class.hashCode();
        //�������Ӻ�Ƶ��  
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //��������  
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(hashCode
                + " [*] Waiting for messages. To exit press CTRL+C");

        //����������ת����Ϣ����  
//        int prefetchCount = 1;  
//        channel.basicQos(prefetchCount);

        QueueingConsumer consumer = new QueueingConsumer(channel);
        boolean ack = false; //��Ӧ�����
        // ָ�����Ѷ���  
        channel.basicConsume(QUEUE_NAME, ack, consumer);

//        while (true)  
        {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery(60);
            if (delivery != null) {
                String message = new String(delivery.getBody());

                System.out.println(hashCode + " [x] Received '" + message + "'");
                doWork(message);
                System.out.println(hashCode + " [x] Done");

                //��ÿ�δ������һ����Ϣ���ֶ�����һ��Ӧ��  
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }


        }

    }

    /**
     * ÿ�����ʱ1s
     *
     * @param task
     * @throws InterruptedException
     */
    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}  
