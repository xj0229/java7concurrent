package com.xiejun.java7concurrenttest.c411p175;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable{
	private String name;
	private CompletionService<String> service;
	
	public ReportRequest(String name, CompletionService<String> service){
		this.name = name;
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ReportGenerator reportGenerator = new ReportGenerator(this.name, "Report");
		service.submit(reportGenerator);
		
	}

}
