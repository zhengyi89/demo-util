package com.sample.reflect;

import java.lang.reflect.Constructor;

public class TestMain {

	/**
	 * 
	 * 带参对象反射创建
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// 根据类名获取Class对象
			Class c = Test.class;
			// 参数类型数组
			Class[] parameterTypes = { int.class, int.class };
			// 根据参数类型获取相应的构造函数
			Constructor constructor = c.getConstructor(parameterTypes);
			// 参数数组
			Object[] parameters = { 2, 1 };
			// 根据获取的构造函数和参数，创建实例
			Object o = constructor.newInstance(parameters);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
