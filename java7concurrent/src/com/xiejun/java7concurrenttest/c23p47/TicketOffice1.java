package com.xiejun.java7concurrenttest.c23p47;

public class TicketOffice1 implements Runnable{
	
	private Cinema cinema;
	
	public TicketOffice1(Cinema c){
		this.cinema = c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		cinema.sellTickets1(3);
		cinema.sellTickets1(3);
		cinema.sellTickets2(3);
		cinema.returnTickets1(3);
		cinema.sellTickets1(5);
		cinema.sellTickets2(5);
		cinema.sellTickets2(1);
	}

}
