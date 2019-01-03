/**
 * 
 */
package com.raushan;

/**
 * @author Raushan kumar
 *
 */
public class ThreadTest extends Thread{
   
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("run started by thread: "+currentThread().getName());
		for(int i=0;i<=5000;i++) {
			if(i==5000)
				throw new NullPointerException();
		}
		System.out.println("run started by thread: "+currentThread().getName());
	}
	public static void main(String[] args) {
	   System.out.println("Main started by thread: "+currentThread().getName());
	   try{
	   new ThreadTest().start();
	   }catch (NullPointerException e) {
		System.out.println("NullPointer Ex: by threat: "+currentThread().getName());
	}
	   System.out.println("Main ended by thread: "+currentThread().getName()); 
   }
}
