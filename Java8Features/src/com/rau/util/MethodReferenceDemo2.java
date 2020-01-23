package com.rau.util;

public class MethodReferenceDemo2 {
	
	private void perFormThreadOperation() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread. ");
		}
	}
	
public static void main(String[] args) {
	MethodReferenceDemo2 obj = new MethodReferenceDemo2();
		Runnable r1 = obj :: perFormThreadOperation; //here when ever any one try to call run() then run will refer to perFormThreadOperation(). 
		
		Thread t1 = new Thread(r1);
		t1.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("main thread. ");
		}

	}
}


