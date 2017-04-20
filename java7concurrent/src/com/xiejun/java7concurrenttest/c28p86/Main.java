package com.xiejun.java7concurrenttest.c28p86;

import java.util.function.BiFunction;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiFunction<Integer, Integer, FileMock> fm = FileMock::new;
		FileMock mock = fm.apply(100, 10);
		Buffer buffer = new Buffer(20);
		
		Producer p = new Producer(mock, buffer);
		Thread tp = new Thread(p,"Producer");
		
		Consumer[] c = new Consumer[3];
		Thread[] tc = new Thread[3];
		for(int i = 0; i < 3; i++){
			c[i] = new Consumer(buffer);
			tc[i] = new Thread(c[i], "Consumer"+i);
		}
		
		tp.start();
		for(int i = 0; i < 3; i++){
			tc[i].start();
		}

	}

}
