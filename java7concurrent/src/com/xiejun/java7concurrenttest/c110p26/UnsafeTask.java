package com.xiejun.java7concurrenttest.c110p26;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable{
	
	private Date startDate;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startDate = new Date();
		
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
		
		try {
			//TimeUnit.SECONDS.sleep((int) Math.rint(Math.random()*10));
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
		
	}

}
