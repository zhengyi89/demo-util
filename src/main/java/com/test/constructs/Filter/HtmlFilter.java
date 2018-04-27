package com.test.constructs.Filter;

public class HtmlFilter implements Filter{

	@Override
	public String doFilter(String str) {
		String r = str.replace("<", "[").replace(">", "]");
		return r;
	}

}
