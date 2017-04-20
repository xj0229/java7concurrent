package com.xiejun.java7concurrenttest.c35p108;

public class Results {
	private int[] data;
	
	public Results(int size){
		data = new int[size];
	}

	public int[] getData() {
		return data;
	}

	public void setData(int position, int value) {
		this.data[position] = value;
	}
	
	

}
