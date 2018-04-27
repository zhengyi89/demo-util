package com.test.velocity;

public class User {
	private String name;
	private String age;
	private String pwd;
	
	public User(){}
	public User(String name, String age, String pwd) {
		this.name = name;
		this.age = age;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
