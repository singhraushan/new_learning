package com.rau.util;

public class ConstructorReferenceDemo2 {
	ConstructorReferenceDemo2() {
		System.out.println(" constructor of ConstructorReferenceDemo2 running as child thread");
	}
	
	public static void main(String[] args) {
		// if method of Funtional interface has return type of a class then you can  implement Constructor Reference
		// method of interface T constructor should have same number of parameter & type of parameter.
		Runnable runnable = ConstructorReferenceDemo2 :: new;
		Thread t1 = new Thread(runnable);
		t1.start();
		
	}
}
