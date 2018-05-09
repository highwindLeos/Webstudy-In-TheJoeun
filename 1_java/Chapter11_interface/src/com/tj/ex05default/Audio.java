package com.tj.ex05default;

public class Audio implements RemoteControl {
	
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
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
		System.out.println("현제 오디오 볼륨 : " + volume);
	}

}
