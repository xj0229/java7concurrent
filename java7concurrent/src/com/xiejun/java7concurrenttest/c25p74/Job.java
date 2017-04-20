package com.xiejun.java7concurrenttest.c25p74;

public class Job implements Runnable{
	private PrintQueue pq;
	
	public Job(PrintQueue pq){
		this.pq = pq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
		
		this.pq.printJob(new Object());
		
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}

}
