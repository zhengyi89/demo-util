package com.demo.log;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhengyi
 * @Date: 2019/10/11 16:37
 */
public class Log4JTest {
    static Logger logger = LoggerFactory.getLogger(Log4JTest.class);
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("test", "zhengy test");
        json.put("body", "00000");
        int i = 1;
        while (1==1){
            json.put("count", i++);
            logger.info(json.toJSONString());
            logger.warn(json.toJSONString());
            logger.error(json.toJSONString());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
