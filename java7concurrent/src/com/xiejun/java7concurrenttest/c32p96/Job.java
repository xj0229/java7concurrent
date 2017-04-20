package com.xiejun.java7concurrenttest.c32p96;

public class Job implements Runnable{
	private PrintQueue queue;
	
	public Job(PrintQueue q){
		this.queue = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		this.queue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}

}
