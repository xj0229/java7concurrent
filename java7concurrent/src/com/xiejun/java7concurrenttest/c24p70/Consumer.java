package com.xiejun.java7concurrenttest.c24p70;

public class Consumer implements Runnable{
	private EventStorage storage;
	
	public Consumer(EventStorage es){
		this.storage = es;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++){
			this.storage.get();
		}
	}

}
