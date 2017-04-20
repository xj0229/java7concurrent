package com.xiejun.java7concurrenttest.c110p26;

import java.util.concurrent.TimeUnit;

public class Core {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnsafeTask task = new UnsafeTask();
		
		//SafeTask task = new SafeTask();
		
		for(int i = 0; i < 10; i++){
			Thread t = new Thread(task);
			t.start();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
