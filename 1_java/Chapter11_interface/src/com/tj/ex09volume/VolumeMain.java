package com.tj.ex09volume;

public class VolumeMain {

	public static void main(String[] args) {
		IVolume speaker = new Speaker();
		IVolume tv = new TV();

		speaker.volumeDown(10);
		speaker.volumeUp(120);
		System.out.println("------------------ TV ----------------");
		tv.volumeUp(120);
		tv.volumeDown(10);
		tv.volumeDown(30);
		System.out.println("--------------인터페이스를 이용한 호출--------------------");

		IVolume[] device = { speaker, tv };

		for (IVolume dTemp : device) {
			dTemp.volumeUp();
			dTemp.volumeUp(100);
		}

	}

}
