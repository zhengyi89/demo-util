package com.demo.constructs.Filter;

public class Main {
	public static void main(String[] args) {
		String msg = "��Һã�) <javascritip>��ʼ";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		System.out.println(mp.process());
	}
}
