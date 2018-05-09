package com.tj.ex3multethread;
// 쓰레드  N 개가 쓰레드 1개를 공유하는 작업예제
public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest(); // 스레드 객체 만듬.
		
		Thread threadA = new Thread(threadTest, "A");
		Thread threadB = new Thread(threadTest, "B");
		
		threadA.start();
		threadB.start();
		
		System.out.println("main thread 에서도 작업합니다." + Thread.currentThread().getName());

	}

}
