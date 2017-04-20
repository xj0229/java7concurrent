package com.xiejun.java7concurrenttest.c112p34;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadGroup mtg = new MyThreadGroup("MyThreadGroup");
		
		Task task = new Task();
		
		for(int i = 0; i < 2; i++){
			Thread t = new Thread(mtg, task);
			t.start();
		}

	}

}
