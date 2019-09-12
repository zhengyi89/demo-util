package com.test;

import com.test.dubbo.demo.action.AnnotationAction;
import com.test.dubbo.demo.configuration.ConsumerConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired

	@Test
	public void redisTest() {
		redisTemplate.delete("a");
	}



	@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
		context.start();
		final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
		String hello = annotationAction.doSayHello("world");
	}
}
