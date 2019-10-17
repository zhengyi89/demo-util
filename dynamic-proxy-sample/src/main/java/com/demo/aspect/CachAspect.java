package com.demo.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.demo.anno.Cach;
import com.demo.spring.el.SpellParser;

@Component
@Aspect
public class CachAspect {

	private final static Logger logger = LoggerFactory.getLogger(CachAspect.class);

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	/**
	 * 拦截com.test下所有的类的所有方法
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution( * com.test1..*.*(..))")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("do before ...");
		Object rst = joinPoint.proceed();
		System.out.println("do end ...");
		return rst;
	}

	/**
	 * 拦截加了@cach的
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(anno)")
	public Object doAround(ProceedingJoinPoint joinPoint, Cach anno) throws Throwable {
		System.out.println("cach before ...");
		String key = getKey(anno.key(), joinPoint);
		String bussName = anno.bussName();
		boolean needLog = anno.needLog();
		// 1.根据ID从缓存中获取数据
		Object obj = redisTemplate.opsForValue().get(bussName + key);
		if (obj != null) {
			logger.info("命中缓存:{}", JSON.toJSONString(obj));
			return obj;
		} else {
			obj = joinPoint.proceed();
			if (obj != null) {
				redisTemplate.opsForValue().set(bussName + key, obj);
				logger.info("写入缓存：{}", JSON.toJSONString(obj));
			}

		}
		if (needLog) {
			logger.info("logger ........");
		}
		System.out.println("cach end ...");
		return obj;
	}

	private String getKey(String key, ProceedingJoinPoint joinPoint) {
		// 获取切面方法
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		// 拿到形参名
		String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
		return SpellParser.getKey(key, parameterNames, joinPoint.getArgs());
	}

}
