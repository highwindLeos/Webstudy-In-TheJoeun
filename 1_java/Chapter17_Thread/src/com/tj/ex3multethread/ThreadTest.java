package com.tj.ex3multethread;

public class ThreadTest implements Runnable {
	private int testRun = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			test();
			// 잠깐 잠재워
		} // for
	}// run

	private synchronized void test() {  
		// synchronized : 하나의 쓰레드를 모두 수행 하기전에는 다른 쓰레드는 실행되지 않는다.
		
		if (Thread.currentThread().getName().equals("A")) {
			testRun++;
			System.out.println("- - - A 수행중 - - -");
		}
		System.out.println("testNum = " + testRun + "Thread Name = " + Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
	}
}
