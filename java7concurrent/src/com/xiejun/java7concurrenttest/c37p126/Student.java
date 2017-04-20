package com.xiejun.java7concurrenttest.c37p126;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable{
	private Phaser phaser;
	
	public Student(Phaser p){
		this.phaser = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: has arrived to do the exam. %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: is going to do the first exercise. %s\n", Thread.currentThread().getName(), new Date());
		doExercise1();
		System.out.printf("%s: has done the first exercise. %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: is going to do the second exercise. %s\n", Thread.currentThread().getName(), new Date());
		doExercise2();
		System.out.printf("%s: has done the second exercise. %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: is going to do the third exercise. %s\n", Thread.currentThread().getName(), new Date());
		doExercise3();
		System.out.printf("%s: has done the exam. %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
	}
	
	
	
	
	private void doExercise1(){
		long duration = (long) (Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doExercise2(){
		long duration = (long) (Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doExercise3(){
		long duration = (long) (Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
