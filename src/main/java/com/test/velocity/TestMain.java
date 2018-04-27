package com.test.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.implement.IncludeRelativePath;
import org.apache.velocity.runtime.RuntimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain {
	
	private Logger logger = LoggerFactory.getLogger(TestMain.class);
	
	public static void main(String[] args) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", "郑义");
		paramMap.put("age", "17");
		paramMap.put("sex", "男");
		User user = new User("张三", "18", "zy57510015");
		paramMap.put("user", user);
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		paramMap.put("list", list);
		String xmlStr = generateMsgBody(paramMap);
		System.out.println(xmlStr);
	}

	/**
	 * 根据调用命令的模板，把调用方法的参数转变为xml
	 * @param paramMap
	 * @param transCodeEnum
	 * @return
	 * @throws Exception
	 */
	private static String generateMsgBody(Map<String, Object> paramMap) throws Exception {

		Properties properties = new Properties();
		properties.put("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		properties.setProperty(RuntimeConstants.EVENTHANDLER_INCLUDE, IncludeRelativePath.class.getName());

		VelocityEngine velocityEngine = new VelocityEngine();

		// 处理中文问题
		velocityEngine.setProperty(Velocity.INPUT_ENCODING, "gbk");
		velocityEngine.setProperty(Velocity.OUTPUT_ENCODING, "gbk");

		velocityEngine.init(properties);

		VelocityContext velocityContext = new VelocityContext();
		for(String key : paramMap.keySet()){
			velocityContext.put(key, paramMap.get(key));
		}

		Template template = velocityEngine.getTemplate("template/msg.xml", "UTF8");
		StringWriter wt = new StringWriter();
		template.merge(velocityContext, wt);
		wt.flush();

		return wt.getBuffer().toString();
	}

}
