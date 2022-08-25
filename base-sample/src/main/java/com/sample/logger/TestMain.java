
package com.sample.logger;

import com.sample.math.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain {
    static Logger logger = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {
        try{
            int i = 1/0;
        }catch (Exception e){
            logger.error("calculate {} error", "1/0", e);
        }
    }
}
