package com.xiejun.java7concurrenttest.c44p146;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		List<Future<Integer>> resultList = new ArrayList<>();
		
		Random random = new Random();
		
		for(int i = 0; i < 10; i++){
			Integer number = random.nextInt(10);
			FactorialCalculator fc = new FactorialCalculator(number);
			Future<Integer> fi = executor.submit(fc);
			resultList.add(fi);
		}
		
		do{
			System.out.printf("Main: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
			
			for(int i = 0; i < resultList.size(); i++){
				Future<Integer> result = resultList.get(i);
				System.out.printf("Main: Task %d: %s\n", i, result.isDone());
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while(executor.getCompletedTaskCount() < resultList.size());
		
		System.out.printf("Main: Results\n");
		for(int i = 0; i < resultList.size(); i++){
			Future<Integer> result = resultList.get(i);
			Integer number = null;
			try {
				number = result.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.printf("Main: Task %d: %d\n", i, number);
		}
		
		executor.shutdown();

	}

}
