package com.xiejun.java7concurrenttest.c14p9;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t = new PrimeGenerator();
		
		t.start();
		
		try{
			TimeUnit.SECONDS.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		t.interrupt();

	}

}
