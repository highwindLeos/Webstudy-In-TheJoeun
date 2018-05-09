package com.tj.ex11timer;
import java.util.TimerTask;

public class TimertaskEx1 extends TimerTask { // TimerTask 추상 클래스를 상속해서 안의 추상 메소드를 오버라이드.

	@Override
	public void run() {
		System.out.println("☆TimertaskEx1 작업은 1초마다 할꺼야");
	}
	

}
