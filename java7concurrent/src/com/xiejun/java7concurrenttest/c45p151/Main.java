package com.xiejun.java7concurrenttest.c45p151;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "test";
		String password = "test";
		
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DataBase");
		
		TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
		TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
		
		List<TaskValidator> tasklist = new ArrayList<>();
		tasklist.add(ldapTask);
		tasklist.add(dbTask);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		String result;
		
		try {
			result = executor.invokeAny(tasklist);
			System.out.printf("Main: Result: %s\n", result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
		System.out.printf("Main: End of the Execution\n");

	}

}
