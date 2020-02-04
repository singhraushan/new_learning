package com.rau.sentosa.util;

import java.math.BigDecimal;

public enum CurrencyType {

	USD(new BigDecimal(1.34)), 
	INR(new BigDecimal(50)),
	SGD(new BigDecimal(0.74));// here need to add if you want more currency but all with respect to sgd
	
	
	public BigDecimal rate;

	CurrencyType(BigDecimal rate) {
		this.rate = rate;
	}

}
