package com.xiejun.java7concurrenttest.c35p108;

public class Grouper implements Runnable{
	private Results results;
	
	public Grouper(Results r){
		this.results = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int finalResult = 0;
		System.out.printf("Grouper: Processing results...\n");
		
		int[] data = results.getData();
		for(int number:data){
			finalResult += number;
		}
		
		System.out.printf("Grouper: Total result: %d.\n", finalResult);
	}

}
