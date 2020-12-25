package com.sample.spring;

import com.sample.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @Author: zhengyi
 * @Date: 2019/12/12 14:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringApplicationTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
        int i = 1/0;
    }

    /**
     * 从spring容器中获取对象并调用方法
     */
    @Test
    public void methodInvokeTest() {
        TestController testController = ApplicationContextUtil.getBean(TestController.class);
        String s = testController.test("lxy");
        assertEquals("hello lxy", s);

        TestController testController1 = ApplicationContextUtil.getBean("testController", TestController.class);
        assertTrue(testController == testController1);
    }

    /**
     * 打印容器中的对象名称
     */
    @Test
    public void beanDependiceTest() {
        ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("---------------" + beanDefinitionName);
        }
    }
}
