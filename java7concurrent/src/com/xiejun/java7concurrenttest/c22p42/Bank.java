package com.xiejun.java7concurrenttest.c22p42;

public class Bank implements Runnable{
	private Account account;
	
	public Bank(Account a){
		this.account = a;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++){
			account.subtractAmount(1000);
		}
	}

}
