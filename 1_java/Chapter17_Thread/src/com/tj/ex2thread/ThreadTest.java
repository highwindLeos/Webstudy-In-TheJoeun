package com.tj.ex2thread;

public class ThreadTest extends Thread {
	
	@Override // ���ÿ� ������ ���� ���⿡ ����Ѵ�.
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread Test");
		
		for(int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {	}
		}
	}
	
}
