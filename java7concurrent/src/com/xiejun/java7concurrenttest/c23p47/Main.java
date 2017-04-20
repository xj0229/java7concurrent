package com.xiejun.java7concurrenttest.c23p47;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cinema ci = new Cinema();
		
		TicketOffice1 to1 = new TicketOffice1(ci);
		Thread t1 = new Thread(to1, "TicketOffice1");
		
		TicketOffice2 to2 = new TicketOffice2(ci);
		Thread t2 = new Thread(to2, "TicketOffice1");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 Vacancies: %d\n", ci.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies: %d\n", ci.getVacanciesCinema2());

	}

}
