package com.xiejun.java7concurrenttest.c27p82;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Lock queueLock = new ReentrantLock(false);
	
	public void printJob(Object document){
		this.queueLock.lock();
		
		try {
			long duration = (long)(Math.random()*10000);
			
			System.out.println(Thread.currentThread().getName()+": PrintQueue: Printing a Job during "+(duration / 1000)+" seconds");
			
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.queueLock.unlock();
		}
		
		this.queueLock.lock();
		
		try {
			long duration = (long)(Math.random()*10000);
			
			System.out.println(Thread.currentThread().getName()+": PrintQueue: Printing a Job during "+(duration / 1000)+" seconds");
			
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.queueLock.unlock();
		}		
		
	}
}
