package com.tj.ex1runerble;

public class ThreadTest implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread Test");

		for (int i = 0; i < 10; i++) {
			System.out.println("i=" + i);
			try {
				Thread.sleep(500);// 0.5ÃÊ
			} catch (InterruptedException e) {
			}
		}

	}
}