package com.tj.ex4objectn_threadn;
// 쓰레드  N 개가 쓰레드 1개를 공유하는 작업예제
public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadTestA = new ThreadTest(); // 스레드 객체 만듬.
		ThreadTest threadTestB = new ThreadTest(); // 스레드 객체 만듬.
		
		Thread threadA = new Thread(threadTestA, "A"); // 두개의 작업은 다른 객체를 참조하여 진행됨.
		Thread threadB = new Thread(threadTestB, "B");
		
		threadA.start();
		threadB.start();
		
		System.out.println("main thread 에서도 작업합니다." + Thread.currentThread().getName());

	}

}
