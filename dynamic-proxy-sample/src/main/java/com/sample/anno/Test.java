package com.sample.anno;

import java.lang.reflect.Method;

public class Test {
	@CustomerAnno(priority = CustomerAnno.Priority.MEDIUM, author = "Yashwant", status = CustomerAnno.Status.STARTED)
	public void incompleteMethod1() {
			//Some business logic is written
			//But it’s not complete yet
	}
	
	public static void main(String[] args) {
		Class testClass = Test.class;
		for(Method method : testClass.getMethods()) {
		CustomerAnno todoAnnotation = (CustomerAnno)method.getAnnotation(CustomerAnno.class);
		if(todoAnnotation != null) {
			System.out.println(" Method Name : " + method.getName());
			System.out.println(" Author : " + todoAnnotation.author());
			System.out.println(" Priority : " + todoAnnotation.priority());
			System.out.println(" Status : " + todoAnnotation.status());
		}
		}

	}
	
}

