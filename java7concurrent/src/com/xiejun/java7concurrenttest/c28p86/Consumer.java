package com.xiejun.java7concurrenttest.c28p86;

import java.util.Random;

public class Consumer implements Runnable{
	private Buffer buffer;
	
	public Consumer(Buffer b){
		this.buffer = b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(buffer.hasPendingLines()){
			String line = buffer.get();
			processLine(line);
		}
	}
	
	private void processLine(String line){
		try{
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
