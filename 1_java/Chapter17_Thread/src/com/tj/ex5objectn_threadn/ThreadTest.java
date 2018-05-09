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
	public synchronized void run() { // �� �������� �۾��� ����ɶ� �ٸ� �۾��� ������� �ʰ� �޼ҵ带 �����Ѵ�.
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				testRun++;
				System.out.println("- - - " + Thread.currentThread().getName() + " ������ - - -");
			}
			
			System.out.println("testNum = " + testRun + 
					"\tThread Name = " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	}// run
}
