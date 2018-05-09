package com.tj.ex05default;

public class Audio implements RemoteControl {
	
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("������� �մϴ�.");
	}

	@Override
	public void turnOff() {
		System.out.println("������� ���ϴ�.");
	}

	@Override
	public void setVolum(int volume) {
		if (MAX_VOLUME < volume) {
			this.volume = MAX_VOLUME;
		} else if (MIN_VOLUME > volume) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("���� ����� ���� : " + volume);
	}

}
