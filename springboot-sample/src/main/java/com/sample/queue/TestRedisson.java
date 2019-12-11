package com.sample.queue;
import java.util.Map;

import org.junit.Test;
import org.redisson.Config;
import org.redisson.RedissonClient;
import org.redisson.SingleServerConfig;
import org.redisson.core.RBlockingQueue;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

/**
 * Created by wangnian on 2016/5/2.
 *博客地址：http://my.oschina.net/wangnian
 */
public class TestRedisson {
	 @Test
	    public void test() throws InterruptedException {
	        //redisson配置
	        Config config = new Config();
	        SingleServerConfig singleSerververConfig = config.useSingleServer();
	        singleSerververConfig.setAddress("redis.yunpal.in:6379");
//	        singleSerververConfig.setPassword("redis");
	        //redisson客户端
	        RedissonClient redissonClient = RedisUtils.getInstance().getRedisson(config);
	        
//	        RSortedSet<Object>  rsortSet = RedisUtils.getInstance().getRSortedSet(redissonClient, "whatKKKKK");
	        RBlockingQueue<Map<String,String>> rBlockingQueue = RedisUtils.getInstance().getRBlockingQueue(redissonClient, "XMCMBCBCDQUEUE4");
//	        RBucket<Object> rBucket = RedisUtils.getInstance().getRBucket(redissonClient, "key");
	        //rBucket.set("wangnian");
//	        System.out.println(rBucket.get());
	        	        
//	        rBlockingQueue.clear();

	        System.out.println("startsize="+rBlockingQueue.size());
	        
	        Map<String,String> m = Maps.newHashMap();
	        m.put("withdraw", "87968796859");
	        Map<String,String> m1 = Maps.newHashMap();
	        m1.put("query", "000000000000");
	        Map<String,String> m2 = Maps.newHashMap();
	        m2.put("withdraw", "1111111111");
	        Map<String,String> m3 = Maps.newHashMap();
	        m3.put("withdraw", "333333333");
	        
	        //把anObject加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断,直到BlockingQueue里面有空间再继续.
	        rBlockingQueue.put(m);
	        rBlockingQueue.put(m2);
	        rBlockingQueue.put(m1);
	        rBlockingQueue.put(m3);
	        
	        System.out.println("最初的最初的size:"+rBlockingQueue.size());
	        
	        int t = rBlockingQueue.size();
//	        for(int i=0;i<=t;i++){
//	        	//take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到。BlockingQueue有新的数据被加入; 
////	        	Map<String,String> peek  = rBlockingQueue.take();
////		        System.out.println(i+"取出的数据----"+peek);
//		        
//		        /* 查询还是代付,发送报文到银行 */
//		        
//		        
//		        /* 收到返回报文后,如果是代付,则更新记录状态。
//		         * 如果是查询，判断是否是已发送的记录。
//		         * 是已发送的记录发起查询，然后更改数据库状态。
//		         * 然后发送mq消息给代付系统 */
//		        
//		        
//		        /* 发送过后,修改该记录状态。将报文移除 */
//		        
//		        
//		        
//		        
//		        
//		        System.out.println(rBlockingQueue.size());
////		        rBlockingQueue.remove(peek);
//	        }
	        
	        
	        System.out.println("最后的最后:"+rBlockingQueue.size());
	        System.out.println(JSON.toJSON(rBlockingQueue));
	        
	        
//	        Map<String,String> poll  = rBlockingQueue.poll();
//	        Map<String,String> poll10  = rBlockingQueue.poll(10, TimeUnit.MINUTES);
	        
//	        System.out.println(poll);
//	        System.out.println(poll10);
	        

//	        while (true) {
//	            RLock lock = redissonClient.getLock("lock");
//	            lock.tryLock(0, 1, TimeUnit.SECONDS);//第一个参数代表等待时间，第二是代表超过时间释放锁，第三个代表设置的时间制
//	            try {
//	                System.out.println("执行");
//	                
//	                
//	                
//	                
//	                
//	                
//	            } finally {
//	                lock.unlock();
//	            }
//	        }
	    }
}
