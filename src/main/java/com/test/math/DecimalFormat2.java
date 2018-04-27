package com.test.math;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * 数字格式化
 * @author zhengy
 *
 */
public class DecimalFormat2 {
	public static void main(String args[]) {
		DecimalFormat df1 = new DecimalFormat("####.000");
		System.out.println(df1.format(1234.56));
		// 得到德国的格式
		Locale.setDefault(Locale.GERMAN);
		DecimalFormat df2 = new DecimalFormat("####.000");
		System.out.println(df2.format(1234.56));
	}
}
