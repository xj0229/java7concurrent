package com.xiejun.java7concurrenttest.c17p17;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSourcesLoader dsloader = new DataSourcesLoader();
		Thread t1 = new Thread(dsloader, "DataSourceThread");
		
		NetworkConnectionsLoader ncloader = new NetworkConnectionsLoader();
		Thread t2 = new Thread(ncloader, "NetworkConnectionLoaderThread");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());

	}

}
