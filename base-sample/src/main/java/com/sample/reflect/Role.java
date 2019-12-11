package com.sample.reflect;



public class Role{  
  
    private Integer id;  
    private String name;  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
     

	public void printString(String s){
		System.out.println("aaaa:"+s);
	}
}  

