package com.xiejun.java7concurrenttest.c22p42;

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public synchronized void addAmount(double a){
		double tmp = balance;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tmp += a;
		balance = tmp;
	}
	
	public synchronized void subtractAmount(double a){
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tmp -= a;
		balance = tmp;
	}

}
