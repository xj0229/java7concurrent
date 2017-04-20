package com.xiejun.java7concurrenttest.c32p96;

import java.util.concurrent.Semaphore;

public class PrintQueue {
	private Semaphore semaphore = null;
	
	public PrintQueue(){
		this.semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document){
		try {
			this.semaphore.acquire();
			
			long duration = (long) (Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
			Thread.sleep(duration);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.semaphore.release();
		}
	}

}
