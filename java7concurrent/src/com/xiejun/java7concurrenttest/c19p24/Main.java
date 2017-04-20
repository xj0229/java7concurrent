package com.xiejun.java7concurrenttest.c19p24;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task = new Task();
		Thread t = new Thread(task);
		t.setUncaughtExceptionHandler(new ExceptionHandler());
		t.start();
		
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(t.isAlive()){
			System.out.println("State: "+t.getState());
		}

	}

}
