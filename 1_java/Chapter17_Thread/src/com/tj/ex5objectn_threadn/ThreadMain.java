package com.tj.ex5objectn_threadn;
// ������  N ���� ������ 1���� �����ϴ� �۾�����
public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadA = new ThreadTest("A"); // ������ ��ü ����.
		ThreadTest threadB = new ThreadTest("B"); // ������ ��ü ����.
		
		threadA.start();
		threadB.start();
		
		System.out.println("main thread ������ �۾��մϴ�." + Thread.currentThread().getName());

	}

}
