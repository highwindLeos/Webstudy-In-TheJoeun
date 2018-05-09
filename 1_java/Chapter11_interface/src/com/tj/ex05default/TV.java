package com.tj.ex05default;

public class TV implements RemoteControl {
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("TV를 꼅니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolum(int volume) {
		
		if (MAX_VOLUME < volume) {
			this.volume = MAX_VOLUME;
		} else if(MIN_VOLUME > volume) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현제 볼륨은 " + this.volume);
	}

}
