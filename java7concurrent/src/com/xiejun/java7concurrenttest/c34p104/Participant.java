package com.xiejun.java7concurrenttest.c34p104;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{
	private Videoconference vc;
	private String name;
	
	public Participant(Videoconference vc, String name){
		this.vc = vc;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long duration = (long) (Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vc.arrive(name);
	}

}
