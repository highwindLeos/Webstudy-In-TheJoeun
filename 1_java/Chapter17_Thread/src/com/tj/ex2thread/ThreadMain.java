package com.tj.ex2thread;

public class ThreadMain {

	public static void main(String[] args) {
		
		ThreadTest thread = new ThreadTest(); // �۾�run() �� ���� �ְ� thread �� �ִ�.
		thread.setName("�۾�A"); // �������� �̸��� �ش�.
		
		thread.start();
		
		System.out.println("���� �Լ� ���� ��� : "+
				Thread.currentThread().getName());
		
		System.out.println("���� ������� �Ϸᰡ �Ǿ���.");
		
	}

}
