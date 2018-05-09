package com.tj.ex1runerble;

public class ThreadMain {

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		// 스레드 생성. "작업A" 라는 이름을 가지고 있다.
		Thread thread = new Thread(threadTest, "작업A");

		thread.start(); // "작업A" 스레드 시작. 메소드 run()에 있는 작업을 수행.

		System.out.println("메인 함수에서 출력함 : " 
				+ Thread.currentThread().getName());
	}

}
