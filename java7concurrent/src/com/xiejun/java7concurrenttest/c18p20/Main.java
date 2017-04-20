package com.xiejun.java7concurrenttest.c18p20;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Event> deque = new ArrayDeque<>();
		
		WriterTask writer = new WriterTask(deque);
		
		for(int i = 0; i < 3; i++){
			Thread t = new Thread(writer);
			t.start();
		}
		
		CleanerTask cleaner = new CleanerTask(deque);
		cleaner.start();

	}

}
