package com.xiejun.java7concurrenttest.c45p151;

import java.util.Base64;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	private String name;
	
	public UserValidator(String n){
		this.name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean validate(String name, String password){
		Random random = new Random();
		long duration = (long) (Math.random()*10);
		System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
		try {
			System.out.println("Base64Encode: --"+Base64.getEncoder().encodeToString(this.name.getBytes())+"--");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return random.nextBoolean();
	}

}
