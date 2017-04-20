package com.xiejun.java7concurrenttest.c44p146;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer>{
	private Integer number;
	
	public FactorialCalculator(Integer n){
		this.number = n;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int result = 1;
		if((number == 0)||(number == 1)){
			result = 1;
		}else{
			for(int i = 2; i <= number; i++){
				result *= i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		
		System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
		return result;
	}

}
