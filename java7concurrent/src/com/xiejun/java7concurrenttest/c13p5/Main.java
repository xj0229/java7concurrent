package com.xiejun.java7concurrenttest.c13p5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Thread threads[] = new Thread[10];
		
		Thread.State status[] = new Thread.State[10];
		
		boolean finish = false;
		
		for(int i = 0; i < 10; i++){
			threads[i] = new Thread(new Calculator(i));
			
			if((i%2) == 0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			
			threads[i].setName("Thread"+i);
		}
		
		try(FileWriter file = new FileWriter(".\\data\\log.txt");
				PrintWriter pw = new PrintWriter(file);){
			for(int i = 0; i < 10; i++){
				pw.println("Main : Status of Thread "+i+":"+threads[i].getState());
				
				status[i] = threads[i].getState();
			}
			
			
			
			for(int i = 0; i < 10; i++){
				threads[i].start();
			}
			

			while(!finish){
				for(int i = 0; i < 10; i++){
					
					if(threads[i].getState() != status[i]){
						writeThreadInfo(pw, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
					
				}
				
				finish = true;
			}
			

			
//			for(int i = 0; i < 10; i++){
//				finish = finish && (threads[i].getState() == State.TERMINATED);
//			}
		}
		
		//TimeUnit.SECONDS.sleep(60);
		


	}
	
	
	
	private static void writeThreadInfo(PrintWriter pw, Thread t, State s){
		pw.printf("Main : Id %d - %s\n", t.getId(), t.getName());
		pw.printf("Main : Priority: %d\n", t.getPriority());
		pw.printf("Main : Old State: %s\n", s);
		pw.printf("Main : New State: %s\n", t.getState());
		pw.printf("Main : *****************************************\n");
	
	}

}
