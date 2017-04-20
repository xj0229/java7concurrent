package com.xiejun.java7concurrenttest.c33p100;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintQueue q = new PrintQueue();
		
		Thread[] t = new Thread[10];
		for(int i = 0; i < 10; i++){
			t[i] = new Thread(new Job(q),"Thread"+i);
		}
		
		for(int i = 0; i < 10; i++){
			t[i].start();
		}
	}

}
