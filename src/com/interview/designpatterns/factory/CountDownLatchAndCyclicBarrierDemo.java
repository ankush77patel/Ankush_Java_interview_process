package com.interview.designpatterns.factory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class Worker implements Runnable {
	private CountDownLatch latch;

	Worker(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Thread running " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			System.out.println("Release Thread " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Signal that the task is complete
			latch.countDown();
		}

	}

}

class CyclicWorker implements Runnable {
	private CyclicBarrier latch;

	CyclicWorker(CyclicBarrier latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Thread running " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			System.out.println("Release Thread " + Thread.currentThread().getName());
			latch.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

public class CountDownLatchAndCyclicBarrierDemo {

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Worker(latch),"CountDownLatch"+i);
			t.start();
		}

		latch.await();
		   System.out.println("All worker threads have completed their tasks.");
		   
		   System.out.println("=======================");
		   
		  CyclicBarrier cb=new CyclicBarrier(3);
		  
		  for (int i = 0; i < 3; i++) {
				Thread t = new Thread(new CyclicWorker(cb),"Barior"+i);
				t.start();
			}
		  
		  System.out.println("All worker threads have completed their tasks.");
	}
}
