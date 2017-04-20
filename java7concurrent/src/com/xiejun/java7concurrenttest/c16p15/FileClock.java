package com.xiejun.java7concurrenttest.c16p15;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			System.out.printf("%s\n", new Date());
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.printf("The FileClock has been interrupted");
			}
		}
	}

}
