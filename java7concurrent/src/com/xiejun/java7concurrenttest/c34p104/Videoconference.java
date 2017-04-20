package com.xiejun.java7concurrenttest.c34p104;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable{
	private CountDownLatch controller;
	
	public Videoconference(int n){
		this.controller = new CountDownLatch(n);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
		try {
			controller.await();
			System.out.printf("VideoConference: All the participants have come\n");
			System.out.printf("Let's start.....");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void arrive(String name){
		System.out.printf("%s has arrived.", name);
		controller.countDown();
		System.out.printf("Video Conference: waiting for %d participants.\n", controller.getCount());
	}

}
