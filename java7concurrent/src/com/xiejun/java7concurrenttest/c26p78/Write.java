package com.xiejun.java7concurrenttest.c26p78;

public class Write implements Runnable{
	private PricesInfo pri;
	
	public Write(PricesInfo pi){
		this.pri = pi;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i++){
			System.out.printf("Writer: Attempt to modify the prices.\n");
			this.pri.setPrices(Math.random()*10, Math.random()*8);
			System.out.printf("Writer: Prices have been modified.\n");
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
