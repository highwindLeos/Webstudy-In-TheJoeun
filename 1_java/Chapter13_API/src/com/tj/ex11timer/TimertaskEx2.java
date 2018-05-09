package com.tj.ex11timer;
import java.util.TimerTask;

public class TimertaskEx2 extends TimerTask { // TimerTask 추상 클래스를 상속해서 안의 추상 메소드를 오버라이드.
	// timer 로 할일을 만들어 놓는다.
	@Override
	public void run() {
		System.out.println("★TimertaskEx2 작업은 5초마다 할꺼야");
	}
	
}
