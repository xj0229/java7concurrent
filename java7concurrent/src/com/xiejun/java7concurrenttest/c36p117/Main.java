package com.xiejun.java7concurrenttest.c36p117;

import java.util.concurrent.Phaser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phaser phaser = new Phaser(3);
		
		FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
		FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
		FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);
		
		Thread ts = new Thread(system, "system");
		ts.start();
		
		Thread ta = new Thread(apps, "apps");
		ta.start();
		
		Thread td = new Thread(documents, "documents");
		td.start();
		
		try {
			ts.join();
			ta.join();
			td.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main: Terminated: "+phaser.isTerminated());

	}

}
