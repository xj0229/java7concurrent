package com.xiejun.java7concurrenttest.c111p30;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable{
	
	private Result result;
	
	public SearchTask(Result r){
		this.result = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		
		System.out.printf("Thread %s: Start\n", name);
		
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.printf("Thread %s: Interrupted\n", name);
			return;
		}
		
		System.out.printf("Thread %s: End\n", name);
	}
	
	private void doTask() throws InterruptedException{
		Random random = new Random((new Date()).getTime());
		
		int value = (int)(random.nextDouble()*100);
		
		System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
		
		TimeUnit.SECONDS.sleep(value);
	}

}
