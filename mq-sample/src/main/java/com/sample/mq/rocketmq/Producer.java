package com.sample.mq.rocketmq;


import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;

/**
 * @Author: zhengyi
 * @Date: 2019/9/18 16:23
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, InterruptedException {

        //需要一个producer group名字作为构造方法的参数，这里为producer1
        DefaultMQProducer producer = new DefaultMQProducer("producer");

        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
        producer.setNamesrvAddr("10.1.35.18:9876");
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendFailed(2);
        producer.setProducerGroup("eps-pay-api");


        //为避免程序启动的时候报错，添加此代码，可以让rocketMq自动创建topickey
//        producer.setCreateTopicKey("TOPIC_TRANSFER_PAY");
        producer.start();

        String s = "{\"companyAddress\":\"11111\",\"appId\":\"HB\",\"inCome\":\"001\",\"usrProvNo\":\"18\",\"idCardBackID\":\"190820550003235656.jpg\",\"idCardFrontID\":\"190820550003235655.jpg\",\"idExpDt\":\"20230819\",\"bankMblNo\":\"19848007919\",\"socialIdentity\":\"001\",\"qryCreditId\":\"******55000323****\",\"oprMblNo\":\",\"bankCardNo\":\"******856475****\",\"userType\":\"2\",\"usrJob\":\"003\",\"contactRelation\":\"001\",\"requestTm\":\"20190820110000\",\"schooling\":\"001\",\"liveScore\":\"71\",\"zipCode\":\"423600\",\"cusSex\":\"1\",\"hbUsrNo\":\"400002973572\",\"regDt\":\"20190729\",\"usrIdName\":\"ÖÜÑïÇò\",\"idCardFront\":\",\"liveOrgNm\":\"¹úÕþÍ¨¿Æ¼¼ÓÐÏÞ¹«Ë¾\",\"companyName\":\"¸ßÑôÍ¨Áª¹«Ë¾\",\"userMail\":\",\"idCardBack\":\",\"bankCode\":\"SPDB\",\"companyAddressCode\":\"430103\",\"liveOrgId\":\"726372516\",\"address\":\"Ü½ÈØÇø•¨Ôº\",\"contactName\":\"ÖÜÇò\",\"mblNo\":\"19848007919\",\"usrIdCard\":\"******19951029****\",\"addressCode\":\"430102\",\"jrnNo\":\"******20000323****\",\"oprId\":\",\"companyMblNo\":\"07315555555\",\"contactMblNo\":\"13808444639\",\"maritalSta\":\"0\",\"bankCardName\":\"ÖÜÑïÇò\",\"livePictureID\":\"190820550003235654.jpg\",\"livePicture\":\"}";


        for (int i = 0; i < 1; i++) {
            try {
                Message message = new Message("TOPIC_TRANSFER_PAY", "PROTOCOLPAY",
                        ("Hello RocketMQ " + i + "   " + s).getBytes(RemotingHelper.DEFAULT_CHARSET));

                SendResult sendResult = producer.send(message);
                Thread.sleep(1000);

                System.out.println("发送的消息ID:" + sendResult.getMsgId() + "--- 发送消息的状态：" + sendResult.getSendStatus());
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        producer.shutdown();

    }

}
