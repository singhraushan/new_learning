/**
 * 
 */
package com.rau.thread;

/**
 * @author Raushan kumar
 *
 */
public class ConsumerThread extends Thread {
	private SharedResource sharedResource;

	ConsumerThread(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	public void run() {
	      Integer x=0;
	      while (x<5) {
	    	  x = sharedResource.consumer(); 
	      }
		}
}
