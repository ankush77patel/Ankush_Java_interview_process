package com.interview.practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("My Runnable");

	}

}

class MyCallable implements Callable {

	@Override
	public MyCallable call() {
		System.out.println("My Runnable");
		return null;

	}

}

public class MultiThreading {
	public static void main(String[] args) {
		ExecutorService future=Executors.newSingleThreadExecutor();
		
		Future<?> submit =future.submit(new MyRunnable());
		
		Future<?> callable =future.submit(new MyCallable());
		try {
			System.out.println(submit.get());
			System.out.println(callable.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
