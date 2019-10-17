package com.demo.spring.boot.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Boss")
public class Boss {
	@Autowired
	private Car car;
	@Autowired
	private Office office;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "car:" + car + "\n" + "office:" + office;
	}

}