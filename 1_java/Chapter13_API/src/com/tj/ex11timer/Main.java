package com.tj.ex11timer;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("타이머 시작할꺼다.");
		Timer timer = new Timer(false); // true : 프로그램이 종료 될때 까지만 Timer 가 작동.
		
		TimerTask task1 = new TimertaskEx1();
		TimertaskEx2 task2 = new TimertaskEx2();
		
		timer.schedule(task1, 500, 1000); // 0.5초 후부터 1초에 한번 task1.run() 호출하라. 
		timer.schedule(task2, 5000); // 5초후에 -한번- task2.run() 호출하라. 
		
		Thread.sleep(10000); // 10초동안 대기함.
		System.out.println("프로그램 종료");
 	}
}
