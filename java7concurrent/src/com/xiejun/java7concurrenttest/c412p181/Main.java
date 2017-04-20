package com.xiejun.java7concurrenttest.c412p181;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RejectedTaskController controller = new RejectedTaskController();
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		executor.setRejectedExecutionHandler(controller);
		
		System.out.println("Main: Starting.");
		for(int i = 0; i < 3; i++){
			Task task = new Task("Task"+i);
			executor.submit(task);
		}
		
		System.out.println("Main: Shutting down the executor.");
		executor.shutdown();
		
		System.out.println("Main: Sending another task.");
		Task tt = new Task("RRRRRTask");
		executor.submit(tt);
		
		System.out.println("Main: End");

	}

}
