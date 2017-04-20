package com.xiejun.java7concurrenttest.c16p15;

import java.util.concurrent.TimeUnit;

/*
 * Java并发API还提供了另一个方法来使线程对象释放CPU，即yield()方法，
 * 它将通知JVM这个线程对象可以释放CPU了。JVM并不保证遵循这个要求。
 * 通常来说，yield()方法只做调试使用。
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileClock clock = new FileClock();
		
		Thread t = new Thread(clock);
		
		t.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.interrupt();

	}

}
