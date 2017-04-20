package com.xiejun.java7concurrenttest.c411p175;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReportProcess implements Runnable{
	private CompletionService<String> service;
	private boolean end;
	public void setEnd(boolean end){
		this.end = end;
	}
	
	public ReportProcess(CompletionService<String> service){
		this.service = service;
		end = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!end){
			try {
				Future<String> result = service.poll(20, TimeUnit.SECONDS);
				if(result != null){
					String report = result.get();
					System.out.printf("ReportReceiver: Report Received: %s\n", report);
				}
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("ReportSender: End.");
		
	}

}
