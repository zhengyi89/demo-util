package com.sample.json;

import com.alibaba.fastjson.JSONObject;

public class TestMain {
	public static void main(String[] args) {
		
		try {
			String jsonStr = "{1:'aa',2:'bb'}";
			JSONObject json = JSONObject.parseObject(jsonStr);
			System.out.println(json.get("1"));
		} catch (Exception e) {
			System.out.println("得到产品期数对应的利率失败，解析json异常，exp:"+ e.getCause());
		}
		
	}

}
