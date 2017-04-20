package com.xiejun.java7concurrenttest.c48p165;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		System.out.printf("Main: Starting at %s\n", new Date());
		Task ta = new Task("task");
		
		ScheduledFuture<?> result = executor.scheduleAtFixedRate((Runnable) ta, 1, 2, TimeUnit.SECONDS);
		
		for(int i = 0; i < 10; i++){
			System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		System.out.printf("Main: Finished at: %s\n", new Date());

	}

}
