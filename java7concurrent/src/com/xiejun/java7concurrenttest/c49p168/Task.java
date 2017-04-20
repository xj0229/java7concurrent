package com.xiejun.java7concurrenttest.c49p168;

import java.util.concurrent.Callable;

public class Task implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("Task: test");
			Thread.sleep(100);
		}
	}

}
