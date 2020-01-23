package com.rau.util.funtion;

import java.util.Date;
import java.util.function.Supplier;

public interface SupplierDemo1 {
 public static void main(String[] args) {
	Supplier<Date> s1= () -> new Date();
	
	Supplier<String> s2 = () -> {
		String otp="";
		for(int i=0;i<6;i++){
			otp+= (int)(Math.random()*10);
		}
		return otp;
	};
	
	System.out.println(s1.get());
	System.out.println(s2.get());
	System.out.println(s2.get());
	// no supply chain for Supplier
	
}
}
