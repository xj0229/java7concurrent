package com.xiejun.java7concurrenttest.c16p15;

import java.util.concurrent.TimeUnit;

/*
 * Java����API���ṩ����һ��������ʹ�̶߳����ͷ�CPU����yield()������
 * ����֪ͨJVM����̶߳�������ͷ�CPU�ˡ�JVM������֤��ѭ���Ҫ��
 * ͨ����˵��yield()����ֻ������ʹ�á�
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileClock clock = new FileClock();
		
		Thread t = new Thread(clock);
		
		t.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.interrupt();

	}

}
