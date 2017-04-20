package com.xiejun.java7concurrenttest.c47p161;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String>{
	private String name;
	
	public Task(String n){
		this.name = n;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.printf("%s: Starting at %s\n", name, new Date());
		return "Hello, world";
	}

}
