package com.rau.util;

public class MethodReferenceDemo1 {

	private static void perFormThreadOperation() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread. ");
		}
	}

	public static void main(String[] args) {
		
		Runnable r1 = MethodReferenceDemo1 :: perFormThreadOperation; //here when ever any one try to call run() then run will refer to perFormThreadOperation(). 
		
		Thread t1 = new Thread(r1);
		t1.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("main thread. ");
		}

	}
}
