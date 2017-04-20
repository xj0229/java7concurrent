package com.xiejun.java7concurrenttest.c111p30;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup tg = new ThreadGroup("Searcher");
		
		Result result = new Result();
		SearchTask st = new SearchTask(result);
		
		for(int i = 0; i < 10; i++){
			Thread t = new Thread(tg, st);
			t.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("Number of Threads: %d\n", tg.activeCount());
		System.out.printf("Information about the Thread Group\n");
		tg.list();
		
		Thread[] ts = new Thread[tg.activeCount()];
		tg.enumerate(ts);
		for(int i = 0; i < tg.activeCount(); i++){
			System.out.printf("Thread %s: %s\n", ts[i].getName(), ts[i].getState());
		}
		
		waitFinish(tg);
		
		tg.interrupt();
		


	}
	
	private static void waitFinish(ThreadGroup thg){
		while(thg.activeCount() > 9){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
