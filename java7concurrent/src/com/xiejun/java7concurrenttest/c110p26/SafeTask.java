package com.xiejun.java7concurrenttest.c110p26;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{
	
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue() {
			return new Date();
		}
	};

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
		
		try {
			//TimeUnit.SECONDS.sleep((int) Math.rint(Math.random()*10));
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
	}

}
