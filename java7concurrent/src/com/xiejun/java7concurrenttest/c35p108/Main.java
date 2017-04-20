package com.xiejun.java7concurrenttest.c35p108;

import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 4;
		final int PARTICIPANTS = 5;
		final int LINES_PARTICIPANT = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		Results results = new Results(ROWS);
		
		Grouper grouper = new Grouper(results);
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
		
		Searcher[] searchers = new Searcher[PARTICIPANTS];
		for(int i = 0; i < PARTICIPANTS; i++){
			searchers[i] = new Searcher(i*LINES_PARTICIPANT, i*LINES_PARTICIPANT+LINES_PARTICIPANT, mock, results, 5, barrier);
			
			Thread t = new Thread(searchers[i]);
			t.start();
		}
		
		System.out.printf("Main: The main thread has finished.\n");

	}

}
