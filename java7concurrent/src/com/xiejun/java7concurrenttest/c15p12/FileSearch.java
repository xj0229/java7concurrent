package com.xiejun.java7concurrenttest.c15p12;

import java.io.File;

public class FileSearch implements Runnable{
	
	private String initPath;
	private String fileName;
	
	public FileSearch(String p, String f){
		this.initPath = p;
		this.fileName = f;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file = new File(initPath);
		
		if(file.isDirectory()){
			try{
				directoryProcess(file);
			}catch(InterruptedException e){
				System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
			}
		}
	}
	
	private void directoryProcess(File file) throws InterruptedException{
		File list[] = file.listFiles();
		
		if(list != null){
			for(int i = 0; i < list.length; i++){
				if(list[i].isDirectory()){
					directoryProcess(list[i]);
				}else{
					fileProcess(list[i]);
				}
			}
		}
	}
	
	private void fileProcess(File file) throws InterruptedException{
		if(file.getName().equals(fileName)){
			System.out.printf("%s has found : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}
		
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
	}

}
