package com.sample.drools.pojo;

import java.io.Serializable;

/**
 * 规则执行时，参考因素的实际取值
 * 
 * 
 * @author yejiyong
 *
 */
public class FactorVariableValue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3290653913936119429L;
	private String factorName;
	private String factorValue;
	public String getFactorName() {
		return factorName;
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	public String getFactorValue() {
		return factorValue;
	}
	public void setFactorValue(String factorValue) {
		this.factorValue = factorValue;
	}
	
}
