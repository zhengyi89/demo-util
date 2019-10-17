package com.demo.mq.rabbitmq;
import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
import com.rabbitmq.client.QueueingConsumer;  
  
public class ReceiveLogsTopicForCritical  
{  
  
    private static final String EXCHANGE_NAME = "topic_logs";  
  
    public static void main(String[] argv) throws Exception  
    {  
        // �������Ӻ�Ƶ��  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
        // ����ת����  
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");  
        // �������һ������  
        String queueName = channel.queueDeclare().getQueue();  
  
        // ����������kernel��ص���Ϣ  
        channel.queueBind(queueName, EXCHANGE_NAME, "*.critical");  
  
        System.out  
                .println(" [*] Waiting for critical messages. To exit press CTRL+C");  
  
        QueueingConsumer consumer = new QueueingConsumer(channel);  
        channel.basicConsume(queueName, true, consumer);  
  
        while (true)  
        {  
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
            String message = new String(delivery.getBody());  
            String routingKey = delivery.getEnvelope().getRoutingKey();  
  
            System.out.println(" [x] Received routingKey = " + routingKey  
                    + ",msg = " + message + ".");  
        }  
    }  
}  
