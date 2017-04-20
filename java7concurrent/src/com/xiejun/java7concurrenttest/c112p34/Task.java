package com.xiejun.java7concurrenttest.c112p34;

import java.util.Random;

public class Task implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int result;
		Random r = new Random(Thread.currentThread().getId());
		
		while(true){
			result = 1000 / ((int)(r.nextDouble()*1000));
			
			System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);
			
			if(Thread.currentThread().isInterrupted()){
				System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
				return;
			}
		}
		
	}

}
