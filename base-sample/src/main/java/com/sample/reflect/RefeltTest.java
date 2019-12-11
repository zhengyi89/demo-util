package com.sample.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class RefeltTest {
	public static void main(String[] args) throws Exception {
//		Class c = Role.class; 
		Role role = new Role();
		role.setId(11111);
		Class c = role.getClass();
//		Object o = c.newInstance();
//		Role mu = (Role)o;
//		mu.printString("hello world");
		Field[] fs = c.getDeclaredFields();  
		System.out.println("getModifiers:"+Modifier.toString(c.getModifiers()));
		System.out.println("getSimpleName:"+c.getSimpleName());
		for(Field field:fs){  
			System.out.println("getModifiers:"+Modifier.toString(field.getModifiers()));
			System.out.println("getSimpleName:"+field.getType().getSimpleName());
			System.out.println("getName:"+field.getName());
		}  
		Method[] m = c.getDeclaredMethods();
		for (Method method : m) {
			
		}
		Method method = c.getDeclaredMethod("setName", String.class);
		method.invoke(role, "zhengy");
		
		method = c.getDeclaredMethod("getId");
		String ss = method.invoke(role, null).toString();
		System.out.println(ss);
		String s = String.valueOf(c.getDeclaredMethod("getName").invoke(role));
		System.out.println("name:"+s);
	}
	
}
