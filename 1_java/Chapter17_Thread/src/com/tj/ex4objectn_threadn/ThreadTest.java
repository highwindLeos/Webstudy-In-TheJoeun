package com.tj.ex4objectn_threadn;

public class ThreadTest implements Runnable {
	private int testRun = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				testRun++;
				System.out.println("- - - " + Thread.currentThread().getName() + " ¼öÇàÁß - - -");
			}
			
			System.out.println("testNum = " + testRun + 
					"Thread Name = " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	}// run
}
