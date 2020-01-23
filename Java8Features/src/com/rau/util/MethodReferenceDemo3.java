package com.rau.util;

public class MethodReferenceDemo3 {
	public static void main(String[] args) {
		
		MethodReferenceDemo3 obj = new MethodReferenceDemo3();
		
		//doStuff() method and print() should have same number of parameter & type of parameter.
        FuntionalInterf1 fi1 = obj:: doStuff;
        
        fi1.print("hello");// here print method refer to doStuff(String s). It won't call doStuff(String s, String s2). 
        
	}
	
	private boolean doStuff(String s) {
		System.out.println("start of doStuff");
		for (int i =0;i<10;i++) {
			System.out.println("looping s: "+ s);
		}
		System.out.println("end of doStuff");
		return true;
	}
	private boolean doStuff(String s, String s2) {
		System.out.println("start of doStuff");
		for (int i =0;i<10;i++) {
			System.out.println("looping s: "+ s);
		}
		System.out.println("end of doStuff");
		return true;
	}
}
