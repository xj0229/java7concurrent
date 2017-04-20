package com.xiejun.java7concurrenttest.c24p70;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventStorage es = new EventStorage();
		
		Producer p = new Producer(es);
		Thread tp = new Thread(p);
		
		Consumer c = new Consumer(es);
		Thread tc = new Thread(c);
		
		tp.start();
		tc.start();

	}

}
