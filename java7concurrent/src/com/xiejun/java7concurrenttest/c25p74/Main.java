package com.xiejun.java7concurrenttest.c25p74;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintQueue pq = new PrintQueue();
		Thread t[] = new Thread[10];
		for(int i = 0; i < 10; i++){
			t[i] = new Thread(new Job(pq), "Thread"+i);
		}
		
		for(int i = 0; i < 10; i++){
			t[i].start();
		}

	}

}
