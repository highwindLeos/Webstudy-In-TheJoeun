package com.tj.ex1runerble;

public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		// ������ ����. "�۾�A" ��� �̸��� ������ �ִ�.
		Thread thread = new Thread(threadTest, "�۾�A");

		thread.start(); // "�۾�A" ������ ����. �޼ҵ� run()�� �ִ� �۾��� ����.

		System.out.println("���� �Լ����� ����� : " 
				+ Thread.currentThread().getName());
	}

}
