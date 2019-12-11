package com.sample.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * @author  zhengy
 * @date 2016/06/28
 */
public class MainTest {

	public static void main(String[] args) {
		Date date = new Date();
		//获取前一天
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		System.out.println(date);
	}
	
	
	
	/**
	 * 获得指定日期
	 * 
	 * @param date
	 * @param offset 日期偏移量 前一天：1 后一天：－1
	 * @return
	 */
	public static Date getDay(Date date, int offset) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - offset);
		return c.getTime();
	}
	
	/**
	 * 获得指定日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDay(Date date, String format) {
		return date2String(getDay(date, 0), format);
	}
	
	/**
	 * 获得指定日期
	 * 
	 * @param date
	 * @param offset
	 * @param format 日期偏移量 
	 * @return
	 */
	public static String getDay(Date date, String format, int offset) {
		return date2String(getDay(date, offset), format);
	}
	
	/**
	 * 将date类型准成指定format格式的字符串
	 * 
	 * @param day 日期
	 * @param format 指定格式
	 * @return
	 */
	public static String date2String(Date day, String format) {
		String dateStr = new SimpleDateFormat(format).format(day.getTime());
		return dateStr;
	}
	
}
