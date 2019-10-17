package com.demo.lombok;

import lombok.Getter;
import lombok.Setter;

public class TestMain {
	@Setter @Getter private String nni;
	public static void main(String[] args) {
		
		TestMain t = new TestMain();
		t.setNni("111");
		System.out.println(t.getNni());
		
	}

}
