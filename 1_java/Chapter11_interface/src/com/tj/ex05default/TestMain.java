package com.tj.ex05default;

public class TestMain {

	public static void main(String[] args) {
		TV tv = new TV();
		Audio audio = new Audio();
		
		tv.turnOn();
		tv.setVolum(20);
		tv.setMute(true);
		// tv.changeBattery();
		RemoteControl.changeBattery(); // static �޼ҵ�
		System.out.println("�ִ뺼�� : " + RemoteControl.MAX_VOLUME);
		System.out.println("�ּҺ��� : " + tv.MIN_VOLUME);
		tv.turnOff();
		
		audio.turnOn();
		audio.setVolum(15);
		System.out.println("�ִ뺼�� : " + Audio.MAX_VOLUME);
		audio.setMute(false); // default �޼ҵ�
		System.out.println("�ּ� ���� : " + Audio.MIN_VOLUME);
	}

}
