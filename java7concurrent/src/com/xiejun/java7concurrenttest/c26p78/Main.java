package com.xiejun.java7concurrenttest.c26p78;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PricesInfo pi = new PricesInfo();
		
		Reader[] rs = new Reader[5];
		Thread[] trs = new Thread[5];
		for(int i = 0; i < 5; i++){
			rs[i] = new Reader(pi);
			trs[i] = new Thread(rs[i]);
		}
		
		Write w = new Write(pi);
		Thread tw = new Thread(w);
		
		for(int i = 0; i < 5; i++){
			trs[i].start();
		}
		tw.start();

	}

}
