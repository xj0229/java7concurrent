package com.xiejun.java7concurrenttest.c24p70;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
	private int maxSize;
	private List<Date> storage;
	
	public EventStorage(){
		this.maxSize = 10;
		this.storage = new LinkedList<>();
	}
	
	public synchronized void set(){
		while(storage.size() == maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		storage.add(new Date());
		System.out.printf("Set: %d", this.storage.size());
		notifyAll();
	}
	
	public synchronized void get(){
		while(storage.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("Get: %d : %s", this.storage.size(), ((LinkedList<?>)storage).poll());
		notifyAll();
	}

}
