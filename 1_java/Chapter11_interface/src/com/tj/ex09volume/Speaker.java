package com.tj.ex09volume;

public class Speaker implements IVolume {
	private final int SPEAKER_MAX_VOLUME = 100; // 지역 상수. 해당 클레스에만 사용하도록 한다.
	private final int SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;

	@Override
	public void volumeUp() {
		if (volumeLevel < SPEAKER_MAX_VOLUME) { // 작거나 같을때 까지만 true
			volumeLevel++;
			System.out.println("스피커 볼륨을 1만큼 올려 " + volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최대치입니다.");
		} // if
	}

	@Override
	public void volumeUp(int level) {
		// 98 -> 10 만큼 올림
		volumeLevel += level;
		if (volumeLevel > SPEAKER_MAX_VOLUME) { //
			volumeLevel = SPEAKER_MAX_VOLUME;
		} // if
		System.out.println("스피커 볼륨을 " + level + " 만큼 올려 " + volumeLevel);

	}

	@Override
	public void volumeDown() {
		if (volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("스피커 볼륨을 1만큼 내려 " + volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최소치입니다.");
		} // if
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel < SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨이 최소치입니다.");
		} else {
			System.out.println("스피커 볼륨을 " + level + "만큼 내려 " + volumeLevel);
		}// if
	}

}
