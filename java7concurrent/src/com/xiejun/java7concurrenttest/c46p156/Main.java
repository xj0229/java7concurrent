package com.xiejun.java7concurrenttest.c46p156;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		List<Task> tasklist = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			Task task = new Task(String.valueOf(i));
			tasklist.add(task);
		}
		
		List<Future<Result>> resultlist = null;
		try {
			resultlist = executor.invokeAll(tasklist);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		System.out.println("Main: Printing the results");
		resultlist.stream().map(t -> {
			try {
				return t.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).forEach(r->System.out.println(r.getName()+" : "+r.getValue()));
//		for(int i = 0; i < resultlist.size(); i++){
//			Future<Result> future = resultlist.get(i);
//			try {
//				Result result = future.get();
//				System.out.println(result.getName()+" : "+result.getValue());
//			} catch (InterruptedException | ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	}

}
