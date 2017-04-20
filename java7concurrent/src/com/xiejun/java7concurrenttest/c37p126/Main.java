package com.xiejun.java7concurrenttest.c37p126;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPhaser pha = new MyPhaser();
		Student[] students = new Student[5];
		for(int i = 0; i < students.length; i++){
			students[i] = new Student(pha);
			pha.register();
		}
		
		Thread[] ts = new Thread[students.length];
		for(int i = 0; i < ts.length; i++){
			ts[i] = new Thread(students[i], "Student "+i);
			ts[i].start();
		}
		
		for(int i = 0; i < ts.length; i++){
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main: the Phaser has finished: %s.\n", pha.isTerminated());

	}

}
