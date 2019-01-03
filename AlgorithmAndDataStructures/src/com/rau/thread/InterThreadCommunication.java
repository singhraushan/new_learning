/**
 * 
 */
package com.rau.thread;

/**
 * @author Raushan kumar
 *
 */
public class InterThreadCommunication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();
		new ProducerThread(sharedResource).start();
		new ConsumerThread(sharedResource).start();
		
	}

}
