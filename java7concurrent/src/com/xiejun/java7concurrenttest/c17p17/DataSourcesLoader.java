package com.xiejun.java7concurrenttest.c17p17;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Beginning data sources loading: %s\n", new Date());
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Data sources loading has finished: %s\n", new Date());
	}

}
