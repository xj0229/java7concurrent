package com.xiejun.java7concurrenttest.c43p144;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	private ThreadPoolExecutor executor;
	
	public Server(){
		System.out.println("-----------------------"+Runtime.getRuntime().availableProcessors());
		this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	public void executeTask(Task t){
		System.out.println("Server: A new task has arrived");
		
		executor.execute(t);
		
		System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
		System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
	}
	
	public void endServer(){
		executor.shutdown();
	}

}
