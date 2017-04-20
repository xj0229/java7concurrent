package com.xiejun.java7concurrenttest.c46p156;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result>{
	private String name;
	
	public Task(String n){
		this.name = n;
	}

	@Override
	public Result call() throws Exception {
		// TODO Auto-generated method stub
		System.out.printf("%s: Starting \n", this.name);
		
		long duration = (long) (Math.random()*10);
		System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
		TimeUnit.SECONDS.sleep(duration);
		
		int value = 0;
		for(int i = 0; i < 5; i++){
			value += Math.random()*100;
		}
		
		Result result = new Result();
		result.setName(this.name);
		result.setValue(value);
		System.out.println(this.name+": Ends");
		return result;
	}

}
