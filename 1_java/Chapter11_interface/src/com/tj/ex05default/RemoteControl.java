package com.tj.ex05default;
// 상수 , 추상 메소드 default 메소드, static 메소드
public interface RemoteControl {
	public int MAX_VOLUME = 20; // 상수 (final 변수)
	public int MIN_VOLUME = 10; // 상수
	
	public void turnOn();// 추상 메소드 : 인터페이스의 모든 메소드는 추상 메소드
	public void turnOff();// 추상 메소드
	public void setVolum(int volume);
	
	public default void setMute(boolean mute) { ////default keyword :인터페이스 안에서 로직이 있는 함수를 만듬. 
		if(mute) {
			System.out.println("무음처리");
		} else {
			System.out.println("음소거 처리 해제");
		}
	} 
	
	public static void changeBattery() { // static 메소드 : 객체를 만들지 않아도 호출 가능.
		System.out.println("건전지를 바꿉니다.");
	}
	
}
