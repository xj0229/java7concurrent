package com.xiejun.java7concurrenttest.c13p5;

public class Calculator implements Runnable{
	
	private int number;
	
	public Calculator(int n){
		this.number = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i*number);
		}
	}

}
