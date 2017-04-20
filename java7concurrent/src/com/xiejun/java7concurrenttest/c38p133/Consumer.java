package com.xiejun.java7concurrenttest.c38p133;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable{
	private List<String> buffer;
	
	private Exchanger<List<String>> exchanger;
	
	public Consumer(List<String> buffer, Exchanger<List<String>> exchanger){
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int cycle = 1;
		for(int i = 0; i < 10; i++){
			System.out.printf("Consumer: Cycle %d\n", cycle);
			try {
				System.out.println("Consumer------exingexing");
				buffer = exchanger.exchange(buffer);
				System.out.println("Consumer------exedexed");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumer: "+buffer.size());
			
			for(int j = 0; j < 10; j++){
				String message = buffer.get(0);
				System.out.printf("Consumer: %s\n", message);
				buffer.remove(0);
			}
			
			cycle++;
		}
	}

}
