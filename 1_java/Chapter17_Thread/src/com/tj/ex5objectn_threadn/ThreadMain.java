package com.tj.ex5objectn_threadn;
// 쓰레드  N 개가 쓰레드 1개를 공유하는 작업예제
public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadA = new ThreadTest("A"); // 스레드 객체 만듬.
		ThreadTest threadB = new ThreadTest("B"); // 스레드 객체 만듬.
		
		threadA.start();
		threadB.start();
		
		System.out.println("main thread 에서도 작업합니다." + Thread.currentThread().getName());

	}

}
