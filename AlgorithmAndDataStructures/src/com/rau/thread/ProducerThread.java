/**
 * 
 */
package com.rau.thread;

/**
 * @author Raushan kumar
 *
 */
public class ProducerThread extends Thread {
	private SharedResource sharedResource;

	ProducerThread(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	public void run() {
      Integer x=0;
      while (x<5) {
    	  sharedResource.producer(x++); 
    	  System.out.println("Producer x: "+x);
      }
	}

}
