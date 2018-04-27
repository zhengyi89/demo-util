package com.test.serializable;

import java.io.Serializable;

public class Person implements Serializable {       
	private String name = null;       
	private Integer age = null;     
	private Gender gender = null;
	public Person() {          
		System.out.println("none-arg constructor");      
	}       
	public Person(String name, Integer age, Gender gender) {          
		System.out.println("arg constructor");          
		this.name = name;          
		this.age = age;     
		this.gender = gender;
	}       
	public String getName() {          
		return name;     
	
	}       
	public void setName(String name) {          
		this.name = name;      
	}       
	public Integer getAge() {          
		return age;      
	}       
	public void setAge(Integer age) {          
		this.age = age;      
	}      
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override     
	public String toString() {          
		return "[" + name + ", " + age + ", " + gender + "]";      }  
	} 