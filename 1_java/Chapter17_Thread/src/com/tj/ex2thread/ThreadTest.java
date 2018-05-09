package com.tj.ex2thread;

public class ThreadTest extends Thread {
	
	@Override // 동시에 작헙할 일을 여기에 기술한다.
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
