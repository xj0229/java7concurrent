package com.xiejun.java7concurrenttest.c38p133;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable{
	private List<String> buffer;
	
	private Exchanger<List<String>> exchanger;
	
	public Producer(List<String> buffer, Exchanger<List<String>> exchanger){
		this.buffer = buffer;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int cycle = 1;
		for(int i = 0; i < 10; i++){
			System.out.printf("Producer: Cycle %d\n", cycle);
			
			for(int j = 0; j < 10; j++){
				String message = "Event "+((i*10)+j);
				System.out.printf("Producer: %s\n", message);
				buffer.add(message);
			}
			
			try {
				System.out.println("Producer-------exingexing");
				buffer = exchanger.exchange(buffer);
				System.out.println("Producer--------exedexed");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Producer: "+buffer.size());
			cycle++;
		}
	}

}
