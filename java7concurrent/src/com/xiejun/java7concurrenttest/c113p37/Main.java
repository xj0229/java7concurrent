package com.xiejun.java7concurrenttest.c113p37;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadFactory f = new MyThreadFactory("MyThreadfffffff");
		Task task = new Task();
		Thread thread;
		System.out.printf("Starting the Threads\n");
		for(int i = 0; i < 10; i++){
			thread = f.newThread(task);
			thread.start();
		}
		
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n", f.getStats());
		
	}

}
