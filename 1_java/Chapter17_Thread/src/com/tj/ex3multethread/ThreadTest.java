package com.tj.ex3multethread;

public class ThreadTest implements Runnable {
	private int testRun = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			test();
			// ��� �����
		} // for
	}// run

	private synchronized void test() {  
		// synchronized : �ϳ��� �����带 ��� ���� �ϱ������� �ٸ� ������� ������� �ʴ´�.
		
		if (Thread.currentThread().getName().equals("A")) {
			testRun++;
			System.out.println("- - - A ������ - - -");
		}
		System.out.println("testNum = " + testRun + "Thread Name = " + Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
	}
}
