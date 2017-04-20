package com.xiejun.java7concurrenttest.c411p175;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		CompletionService<String> service = new ExecutorCompletionService<>(executor);
		
		ReportRequest faceRequest = new ReportRequest("Face", service);
		ReportRequest onlineRequest = new ReportRequest("Online", service);
		
		Thread faceThread = new Thread(faceRequest);
		Thread onlineThread = new Thread(onlineRequest);
		
		ReportProcess processor = new ReportProcess(service);
		Thread senderThread = new Thread(processor);
		
		System.out.println("Main: Starting the Threads\n");
		faceThread.start();
		onlineThread.start();
		senderThread.start();
		
		try {
			System.out.printf("Main: waiting for the report generators.\n");
			faceThread.join();
			onlineThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main: shutting down the executor.");
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		processor.setEnd(true);
		System.out.println("Main: Ends");

	}

}
