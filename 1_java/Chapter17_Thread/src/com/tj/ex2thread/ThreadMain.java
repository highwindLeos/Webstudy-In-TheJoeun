package com.tj.ex2thread;

public class ThreadMain {

	public static void main(String[] args) {
		
		ThreadTest thread = new ThreadTest(); // 작업run() 도 여기 있고 thread 도 있다.
		thread.setName("작업A"); // 쓰레드의 이름을 준다.
		
		thread.start();
		
		System.out.println("메인 함수 에서 출력 : "+
				Thread.currentThread().getName());
		
		System.out.println("메인 쓰레드는 완료가 되었다.");
		
	}

}
