package com.xiejun.java7concurrenttest.c23p47;

public class TicketOffice2 implements Runnable{

	private Cinema cinema;
	
	public TicketOffice2(Cinema c){
		this.cinema = c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		cinema.sellTickets1(3);
		cinema.sellTickets1(3);
		cinema.sellTickets2(3);
		cinema.returnTickets2(3);
		cinema.sellTickets1(5);
		cinema.sellTickets2(5);
		cinema.sellTickets2(1);
	}

}
