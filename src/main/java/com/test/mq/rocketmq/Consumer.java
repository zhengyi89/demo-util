package com.test.mq.rocketmq;


import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhengyi
 * @Date: 2019/9/18 16:25
 */
public class Consumer {
    private static final String ADDR = "10.1.50.31:9876";

    public static void main(String[] args) throws MQClientException {
        //设置消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CID_LRW_DEV_SUBS");

        consumer.setVipChannelEnabled(false);
        consumer.setNamesrvAddr(ADDR);
        //设置消费者端消息拉取策略，表示从哪里开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //设置消费者拉取消息的策略，*表示消费该topic下的所有消息，也可以指定tag进行消息过滤
        consumer.subscribe("TopicTest1", "*");

        //消费者端启动消息监听，一旦生产者发送消息被监听到，就打印消息，和rabbitmq中的handlerDelivery类似
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("消费mq消息，消息数量为="+ msgs.size());
//                ExecutorService executor = Executors.newFixedThreadPool(1);
//                executor.execute(new Runnable() {
//                    @Override
//                    public void run() {
                        for (MessageExt messageExt : msgs) {
                            String topic = messageExt.getTopic();
                            String tag = messageExt.getTags();
                            String msg = new String(messageExt.getBody());
                            System.out.println("---------"+Thread.currentThread());
                            System.out.println("*********************************");
                            System.out.println("消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + msg + ", tag:" + tag + ", topic:" + topic);
                            System.out.println("*********************************");
//                            try {
//                                Thread.sleep(2000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }

//                    }
//                });


                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //调用start()方法启动consumer
        consumer.start();
        System.out.println("Consumer Started....");
    }

}
