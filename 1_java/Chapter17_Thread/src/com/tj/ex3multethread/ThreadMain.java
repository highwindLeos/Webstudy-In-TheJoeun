package com.tj.ex3multethread;
// ������  N ���� ������ 1���� �����ϴ� �۾�����
public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest(); // ������ ��ü ����.
		
		Thread threadA = new Thread(threadTest, "A");
		Thread threadB = new Thread(threadTest, "B");
		
		threadA.start();
		threadB.start();
		
		System.out.println("main thread ������ �۾��մϴ�." + Thread.currentThread().getName());

	}

}
