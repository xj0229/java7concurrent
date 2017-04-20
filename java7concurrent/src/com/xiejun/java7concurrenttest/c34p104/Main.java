package com.xiejun.java7concurrenttest.c34p104;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Videoconference c= new Videoconference(10);
		Thread tv = new Thread(c);
		tv.start();
		
		for(int i = 0; i < 10; i++){
			Participant p = new Participant(c, "Participant"+i);
			Thread t = new Thread(p);
			t.start();
		}

	}

}
