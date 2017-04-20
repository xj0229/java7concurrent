package com.xiejun.java7concurrenttest.c410p171;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String>{
	private String name;
	
	public String getName(){
		return name;
	}
	
	public ExecutableTask(String n){
		this.name = n;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		long duration = (long) (Math.random()*10);
		System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
		TimeUnit.SECONDS.sleep(duration);
		return "Hello, world. I'm "+name;
	}

}
