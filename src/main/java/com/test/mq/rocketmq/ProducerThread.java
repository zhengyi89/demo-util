package com.test.mq.rocketmq;


import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhengyi
 * @Date: 2019/9/18 16:23
 */
public class ProducerThread {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        String s = "{\"companyAddress\":\"11111\",\"appId\":\"HB\",\"inCome\":\"001\",\"usrProvNo\":\"18\",\"idCardBackID\":\"190820550003235656.jpg\",\"idCardFrontID\":\"190820550003235655.jpg\",\"idExpDt\":\"20230819\",\"bankMblNo\":\"19848007919\",\"socialIdentity\":\"001\",\"qryCreditId\":\"******55000323****\",\"oprMblNo\":\",\"bankCardNo\":\"******856475****\",\"userType\":\"2\",\"usrJob\":\"003\",\"contactRelation\":\"001\",\"requestTm\":\"20190820110000\",\"schooling\":\"001\",\"liveScore\":\"71\",\"zipCode\":\"423600\",\"cusSex\":\"1\",\"hbUsrNo\":\"400002973572\",\"regDt\":\"20190729\",\"usrIdName\":\"ÖÜÑïÇò\",\"idCardFront\":\",\"liveOrgNm\":\"¹úÕþÍ¨¿Æ¼¼ÓÐÏÞ¹«Ë¾\",\"companyName\":\"¸ßÑôÍ¨Áª¹«Ë¾\",\"userMail\":\",\"idCardBack\":\",\"bankCode\":\"SPDB\",\"companyAddressCode\":\"430103\",\"liveOrgId\":\"726372516\",\"address\":\"Ü½ÈØÇø•¨Ôº\",\"contactName\":\"ÖÜÇò\",\"mblNo\":\"19848007919\",\"usrIdCard\":\"******19951029****\",\"addressCode\":\"430102\",\"jrnNo\":\"******20000323****\",\"oprId\":\",\"companyMblNo\":\"07315555555\",\"contactMblNo\":\"13808444639\",\"maritalSta\":\"0\",\"bankCardName\":\"222\",\"livePictureID\":\"190820550003235654.jpg\",\"livePicture\":\"}";

        ExecutorService service = Executors.newFixedThreadPool(5);

                for (int j = 0; j < 10; j++) {
                    final String producer11 = "producer"+j;
                    service.execute(new Runnable() {
                        @Override
                        public void run() {
                    //需要一个producer group名字作为构造方法的参数，这里为producer1
                    DefaultMQProducer producer = new DefaultMQProducer(producer11);

                    //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
                    //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
                    producer.setNamesrvAddr("10.1.50.31:9876");
                    producer.setVipChannelEnabled(false);

                    //为避免程序启动的时候报错，添加此代码，可以让rocketMq自动创建topickey
                    producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
                    try {
                        producer.start();
                    } catch (MQClientException e) {
                        e.printStackTrace();
                    }

                    for (int i = 0; i < 200000; i++) {
                        try {
                            Message message = new Message("TopicTest1", "Tag1",
                                    ("Hello RocketMQ " + i + "   " + s).getBytes(RemotingHelper.DEFAULT_CHARSET));

                            System.out.println(Thread.currentThread());
                            SendResult sendResult = producer.send(message);

                            System.out.println("发送的消息ID:" + sendResult.getMsgId() + "--- 发送消息的状态：" + sendResult.getSendStatus());
                        } catch (Exception e) {
                            System.out.println("异常了。。。。");
                            e.printStackTrace();
                        }
                    }
                }

                    });
//        producer.shutdown();

            }





    }

}
