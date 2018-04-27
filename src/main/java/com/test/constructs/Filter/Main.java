package com.test.constructs.Filter;

public class Main {
	public static void main(String[] args) {
		String msg = "大家好：) <javascritip>开始";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		System.out.println(mp.process());
	}
}
