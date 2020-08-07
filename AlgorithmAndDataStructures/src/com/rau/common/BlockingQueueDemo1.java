package com.rau.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Shared implements Runnable{
	BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
	
	Shared(){
		blockingQueue.add(5);
		blockingQueue.add(10);	
	}
	
	@Override
	public void run() {
		System.out.println("run started by "+Thread.currentThread().getName());
		blockingQueue.add(15);
		System.out.println("run ended by "+Thread.currentThread().getName());
	}
	
}

public class BlockingQueueDemo1 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main started");
		Shared shared = new Shared();
		new Thread(shared,"Thread1").start();
		Thread.sleep(100);
		new Thread(shared,"Thread2").start();
		System.out.println("main ended");
		
	}

}

