package com.xiejun.java7concurrenttest.c49p168;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		Task ta = new Task();
		
		System.out.printf("Main: Executing the Task\n");
		Future<String> result = executor.submit(ta);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main: Canceling the Task");
		result.cancel(true);
		
		System.out.printf("Main: Cancelled: %s\n", result.isCancelled());
		System.out.printf("Main: Done: %s\n", result.isDone());
		
		executor.shutdown();
		System.out.println("Main: the executor has finished\n");
		
	}

}
