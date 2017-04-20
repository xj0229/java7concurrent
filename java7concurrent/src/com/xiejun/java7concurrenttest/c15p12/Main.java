package com.xiejun.java7concurrenttest.c15p12;

import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args){
		FileSearch searcher = new FileSearch("C:\\", "autoexec.bat");
		
		Thread thread = new Thread(searcher);
		
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.interrupt();
	}

}
