package com.xiejun.java7concurrenttest.c26p78;

public class Reader implements Runnable{
	private PricesInfo pri;
	
	public Reader(PricesInfo pi){
		this.pri = pi;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), this.pri.getPrice1());
			System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), this.pri.getPrice2());
		}
	}

}
