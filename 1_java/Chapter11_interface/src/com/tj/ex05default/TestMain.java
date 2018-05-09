package com.tj.ex05default;

public class TestMain {

	public static void main(String[] args) {
		TV tv = new TV();
		Audio audio = new Audio();
		
		tv.turnOn();
		tv.setVolum(20);
		tv.setMute(true);
		// tv.changeBattery();
		RemoteControl.changeBattery(); // static 메소드
		System.out.println("최대볼륨 : " + RemoteControl.MAX_VOLUME);
		System.out.println("최소볼륨 : " + tv.MIN_VOLUME);
		tv.turnOff();
		
		audio.turnOn();
		audio.setVolum(15);
		System.out.println("최대볼륨 : " + Audio.MAX_VOLUME);
		audio.setMute(false); // default 메소드
		System.out.println("최소 볼륨 : " + Audio.MIN_VOLUME);
	}

}
