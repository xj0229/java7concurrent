package com.xiejun.java7concurrenttest.c23p47;

public class Cinema {
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	
	private Object controlCinema1 = null;
	private Object controlCinema2 = null;
	
	public Cinema(){
		this.controlCinema1 = new Object();
		this.controlCinema2 = new Object();
		
		this.vacanciesCinema1 = 20;
		this.vacanciesCinema2 = 20;
	}
	
	public boolean sellTickets1(int n){
		synchronized(controlCinema1){
			if(n < vacanciesCinema1){
				vacanciesCinema1 -= n;
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean sellTickets2(int n){
		synchronized(controlCinema2){
			if(n < vacanciesCinema2){
				vacanciesCinema2 -= n;
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean returnTickets1(int n){
		synchronized(controlCinema1){
			vacanciesCinema1 += n;
			return true;
		}
	}
	
	public boolean returnTickets2(int n){
		synchronized(controlCinema2){
			vacanciesCinema2 += n;
			return true;
		}
	}
	
	public long getVacanciesCinema1(){
		return vacanciesCinema1;
	}
	
	public long getVacanciesCinema2(){
		return vacanciesCinema2;
	}

}
