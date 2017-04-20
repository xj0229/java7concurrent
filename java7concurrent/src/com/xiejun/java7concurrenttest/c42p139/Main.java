package com.xiejun.java7concurrenttest.c42p139;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server ss = new Server();
		for(int i = 0; i < 100; i++){
			Task tt = new Task("Task"+i);
			ss.executeTask(tt);
		}
		ss.endServer();
		

	}

}
