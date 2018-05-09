package com.tj.ex09volume;

public class Speaker implements IVolume {
	private final int SPEAKER_MAX_VOLUME = 100; // ���� ���. �ش� Ŭ�������� ����ϵ��� �Ѵ�.
	private final int SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;

	@Override
	public void volumeUp() {
		if (volumeLevel < SPEAKER_MAX_VOLUME) { // �۰ų� ������ ������ true
			volumeLevel++;
			System.out.println("����Ŀ ������ 1��ŭ �÷� " + volumeLevel);
		} else {
			System.out.println("����Ŀ ������ �ִ�ġ�Դϴ�.");
		} // if
	}

	@Override
	public void volumeUp(int level) {
		// 98 -> 10 ��ŭ �ø�
		volumeLevel += level;
		if (volumeLevel > SPEAKER_MAX_VOLUME) { //
			volumeLevel = SPEAKER_MAX_VOLUME;
		} // if
		System.out.println("����Ŀ ������ " + level + " ��ŭ �÷� " + volumeLevel);

	}

	@Override
	public void volumeDown() {
		if (volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("����Ŀ ������ 1��ŭ ���� " + volumeLevel);
		} else {
			System.out.println("����Ŀ ������ �ּ�ġ�Դϴ�.");
		} // if
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel < SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ �ּ�ġ�Դϴ�.");
		} else {
			System.out.println("����Ŀ ������ " + level + "��ŭ ���� " + volumeLevel);
		}// if
	}

}
