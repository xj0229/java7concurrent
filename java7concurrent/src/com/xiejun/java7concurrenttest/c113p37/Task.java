package com.xiejun.java7concurrenttest.c113p37;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
