package com.xiejun.java7concurrenttest.c42p139;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	private Date initDate;
	private String name;
	
	public Task(String n){
		this.name = n;
		this.initDate = new Date();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
		System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
		
		Long duration = (long) (Math.random()*10);
		System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
		
		
	}

}
