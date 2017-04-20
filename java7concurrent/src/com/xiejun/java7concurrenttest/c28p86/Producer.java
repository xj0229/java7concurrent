package com.xiejun.java7concurrenttest.c28p86;

public class Producer implements Runnable{
	
	//private java.util.function.BiFunction<Integer, Integer, FileMock> fm = FileMock::new;
	private FileMock mock;
	private Buffer buffer;
	
	public Producer(FileMock fm, Buffer b){
		this.mock = fm;
		this.buffer = b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		buffer.setPendingLines(true);
		while(mock.hasMoreLines()){
			String line = mock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}

}
