/**
 * 
 */
package com.rau.thread;

/**
 * @author Raushan kumar
 *
 */
public class SharedResource {
	Integer x;
	boolean shouldCosumerConsume;
	synchronized void producer(Integer x) {
		this.x =x;
		try {
			shouldCosumerConsume = true; 
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized Integer consumer() {
		
		if(shouldCosumerConsume){ 
		System.out.println("Consumer: x: "+x);
		shouldCosumerConsume= false;
		notify();
		}
		return x;
	}
}
