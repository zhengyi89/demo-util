package com.demo.constructs.Filter;

public class MsgProcessor {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String process(){
		String r = msg.replace("<", "[").replace(">", "]");
		return r;
	}

}
