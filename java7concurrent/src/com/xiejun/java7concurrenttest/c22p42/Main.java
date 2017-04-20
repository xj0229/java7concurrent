package com.xiejun.java7concurrenttest.c22p42;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setBalance(1000);
		
		Company c = new Company(account);
		Thread ct = new Thread(c);
		
		Bank b = new Bank(account);
		Thread bt = new Thread(b);
		
		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
		ct.start();
		bt.start();
		
		try {
			ct.join();
			bt.join();
			System.out.printf("Account : Final Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
