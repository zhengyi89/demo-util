package com.sample.spring;

import com.sample.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @Author: zhengyi
 * @Date: 2019/12/12 14:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringApplicationSample {

    @Test
    public void test() {
        TestController testController = ApplicationContextUtil.getBean(TestController.class);
        String s = testController.test("lxy");
        assertEquals("hello lxy", s);

        TestController testController1 = ApplicationContextUtil.getBean("testController", TestController.class);
        assertTrue(testController == testController1);
    }

}
