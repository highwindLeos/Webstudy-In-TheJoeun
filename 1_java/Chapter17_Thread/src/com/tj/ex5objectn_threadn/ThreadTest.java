package com.tj.ex5objectn_threadn;

public class ThreadTest extends Thread {
	private int testRun = 0;
	
	public ThreadTest() {
		this("");
	}
	
	public ThreadTest(String name) {
		super(name);
	}

	@Override
	public synchronized void run() { // 한 쓰레드의 작업이 진행될때 다른 작업이 실행되지 않게 메소드를 정의한다.
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				testRun++;
				System.out.println("- - - " + Thread.currentThread().getName() + " 수행중 - - -");
			}
			
			System.out.println("testNum = " + testRun + 
					"\tThread Name = " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	}// run
}
