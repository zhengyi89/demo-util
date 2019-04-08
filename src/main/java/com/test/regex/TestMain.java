package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.test.string.StringUtils;

/** 
 * @author  zhengy
 * @date 2016/07/19
 */
public class TestMain {
	
	/**
	 * 截取最后一个小数点以及后面的部分
	 */
	@Test
	public void test1(){
		String uri = "aaaa.bbb.ccc?aa8";
		uri = uri.replaceAll("\\.[^\\.^/]+$", "");
		System.out.println(uri);
		
		
		System.out.println(uri.replace('a', ' '));
	}
	
	
	
	public static void main(String[] args) {
		String str = "会员特惠价： 普通会员 ：10.01 ; 铜牌会员 ：10.02 ; 金牌会员 ：10.03 ; 钻石会员 ：10.04 ;";
//		groupMatch(str);
		
		
//		String s = "合计 : 200.元";
//		Pattern pattern = Pattern.compile("(([1-9]\\d*)|0)(\\.(\\d){1,2})?");
//		Matcher m = pattern.matcher(s);
//		
//		if (m.find()) {
//			System.out.println( m.group());
//		}
		
//		String s = "2017-04-03_ybtzt_1_1.xlss";
//		Pattern pattern = Pattern.compile("(.*)_(.*)_(.*)_(.*)\\.xls");
//		Matcher matcher = pattern.matcher(s);
//		while (matcher.find()) {
//			for (int j = 0; j < 4; j++) {
//				System.out.println(matcher.group(j+1));
//			}
//			
//		}
//		System.out.println(matcher.matches());
		
		String s = "{\"msg\":\"成功\",\\\"result\\\":200}";
		System.out.println(s);
		Pattern p = Pattern.compile(".*\\\\\"result\\\\\":200.*");
		System.out.println(p);
		Matcher m = p.matcher(s);
		System.out.println(m.matches());
		
	}
	
	@Test
	public void test(){
		String s = "  private str1 aa_bb;".trim();
		String s1 = "private str aabb;".trim();
		Pattern p = Pattern.compile("^private (\\w+) (\\w+)_(\\w+);$");
		Matcher m = p.matcher(s1);
		boolean needReDo = true;
		
		
		
		while (m.find()) {
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			System.out.println(m.group(3));
		}
		
		
		System.out.println("result:"+m.matches());
		String afterReplace = s.replaceFirst("_"+m.group(3), StringUtils.toUpperCaseFirstOne(m.group(3)));
		System.out.println(afterReplace);
		
	}
	
	
	
	
	public static void groupMatch(String str){
		int i = 0;
		String[] content = new String[4];
		Pattern pattern = Pattern.compile("(\\d+\\.\\d+)");
		Matcher m = pattern.matcher(str);
		while (m.find()) {
			content[i] = m.group(1);
			i = i + 1;
		}

		for (String string : content) {
			System.out.println(string);
		}
	}
}
