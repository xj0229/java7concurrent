package com.xiejun.java7concurrenttest.c38p133;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bufferp = new ArrayList<>();
		List<String> bufferc = new ArrayList<>();
		
		Exchanger<List<String>> exchanger = new Exchanger<>();
		
		Producer pp = new Producer(bufferp, exchanger);
		Consumer cc = new Consumer(bufferc, exchanger);
		
		Thread tp = new Thread(pp);
		Thread tc = new Thread(cc);
		tp.start();
		tc.start();
		

	}

}
