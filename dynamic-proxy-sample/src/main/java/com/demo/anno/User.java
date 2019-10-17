package com.demo.anno;

public class User {
	public User(int age2, String gender2, int id2, String name2) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.age = age2;
		this.gender = gender2;
		this.name = name2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	private int id;
	private String name;
	private int age;
	private String gender;
}
