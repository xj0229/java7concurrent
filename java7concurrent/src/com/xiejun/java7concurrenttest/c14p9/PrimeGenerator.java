package com.xiejun.java7concurrenttest.c14p9;

public class PrimeGenerator extends Thread{
	
	@Override
	public void run(){
		long number = 1L;
		
		while(true){
			//System.out.println("dddddddddddddddddddddd");
			if(isPrime(number)){
				//System.out.println("Number is Prime"+number);
				//System.out.printf("Number %d is Prime", number);
				System.out.printf("Number %d is Prime\n", number);
			}
			
			if(isInterrupted()){
				System.out.println("The Prime Generator has been Interrupted");
				return;
			}
			
			number++;
		}
	}
	
	private boolean isPrime(long n){
		if(n <= 2){
			return true;
		}
		
		for(long i = 2; i < n; i++){
			if((n % i) == 0){
				return false;
			}
		}
		
		return true;
	}

}
