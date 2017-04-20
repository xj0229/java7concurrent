package com.xiejun.java7concurrenttest.c48p165;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable{
	private String name;
	
	public Task(String n){
		this.name = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Starting at %s\n", name, new Date());
	}

//	@Override
//	public String call() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.printf("%s: Starting at %s\n", name, new Date());
//		return "Hello, world";
//	}

}
