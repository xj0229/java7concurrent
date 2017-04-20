package com.xiejun.java7concurrenttest.c412p181;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	private String name;
	
	public Task(String name){
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Task "+name+": Starting");
		long duration = (long) (Math.random()*10);
		System.out.printf("Task %s: ReportGenerator: Generating a report during %d seconds.\n", name, duration);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Task %s: Ending.\n", name);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}
