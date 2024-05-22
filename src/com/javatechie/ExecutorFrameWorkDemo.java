package com.javatechie;

import java.util.LinkedHashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintingRunnable implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i <= 15; i++) {
			System.out.println("Runnable :" + i);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class ExecutorFrameWorkDemo {
	ExecutorService execute = Executors.newFixedThreadPool(5);
	  
	public static void main(String[] args) {
		ExecutorFrameWorkDemo e = new ExecutorFrameWorkDemo();
		for (int i = 1; i <= 5; i++)
			e.execute.submit(new PrintingRunnable());

		e.execute.shutdown();
		System.out.println("Sutdown");
	}

}
