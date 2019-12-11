package com.sample.spring.boot.anno;

import org.springframework.stereotype.Component;

@Component
public class Office {
	private String officeNo = "001";

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	@Override
	public String toString() {
		return "officeNo:" + officeNo;
	}
}