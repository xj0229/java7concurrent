package com.xiejun.java7concurrenttest.c26p78;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {
	private double price1;
	private double price2;
	
	private ReadWriteLock lock;
	
	public PricesInfo(){
		this.price1 = 1.0;
		this.price2 = 2.0;
		lock = new ReentrantReadWriteLock();
	}
	
	public double getPrice1(){
		lock.readLock().lock();
		double value = this.price1;
		lock.readLock().unlock();
		return value;
	}
	
	public double getPrice2(){
		lock.readLock().lock();
		double value = this.price2;
		lock.readLock().unlock();
		return value;
	}
	
	public void setPrices(double d1, double d2){
		lock.writeLock().lock();
		this.price1 = d1;
		this.price2 = d2;
		lock.writeLock().unlock();
	}

}
