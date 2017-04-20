package com.xiejun.java7concurrenttest.c411p175;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String>{
	private String sender;
	private String title;
	
	public ReportGenerator(String s, String t){
		this.sender = s;
		this.title = t;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		long duration = (long) (Math.random()*10);
		System.out.printf("%s_%s: ReportGenerator: generating a report during %d seconds.\n", this.sender, this.title, duration);
		TimeUnit.SECONDS.sleep(duration);
		return this.sender+": "+this.title;
	}

}
