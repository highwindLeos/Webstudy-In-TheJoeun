package com.tj.ex4objectn_threadn;
// ������  N ���� ������ 1���� �����ϴ� �۾�����
public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadTestA = new ThreadTest(); // ������ ��ü ����.
		ThreadTest threadTestB = new ThreadTest(); // ������ ��ü ����.
		
		Thread threadA = new Thread(threadTestA, "A"); // �ΰ��� �۾��� �ٸ� ��ü�� �����Ͽ� �����.
		Thread threadB = new Thread(threadTestB, "B");
		
		threadA.start();
		threadB.start();
		
		System.out.println("main thread ������ �۾��մϴ�." + Thread.currentThread().getName());

	}

}
