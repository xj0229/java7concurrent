package com.xiejun.java7concurrenttest.c47p161;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
		
		System.out.printf("Main: Starting at: %s\n", new Date());
		for(int i = 0; i < 5; i++){
			Task ta = new Task("Task:"+i);
			executor.schedule(ta, i+1, TimeUnit.SECONDS);
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Main: Ends at: %s\n", new Date());

	}

}
