package com.xiejun.java7concurrenttest.c13p5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Maint {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try(FileWriter file = new FileWriter(".\\data\\log.txt");
				PrintWriter pw = new PrintWriter(file);){
			writeThreadInfo(pw, "sdsdffffffffffff");
			while(true){;}
		}

	}
	
	private static void writeThreadInfo(PrintWriter pw, String s){
		pw.printf("Main : Id - %s\n", s);
		pw.printf("Main : *****************************************\n");
	
	}

}
