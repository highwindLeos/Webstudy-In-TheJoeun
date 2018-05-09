package com.tj.ex09volume;

public class TV implements IVolume {
	private final int TV_MAX_VOLUME = 20; // ���� ���. �ش� Ŭ�������� ����ϵ��� �Ѵ�.
	private final int TV_MIN_VOLUME = 0;
	private int volumeLevel;

	@Override
	public void volumeUp() {
		if (volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ������ 1��ŭ �÷� " + volumeLevel);
		} else {
			System.out.println("TV ������ �ִ�ġ���� �ø��� �� �߽��ϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV ������ " + level + "��ŭ �÷��� " + volumeLevel);
		} else { // ���� ������ 18�� �� ������ 10��ŭ �ø��ٰ� �ϸ� 2
			// int tempLevel = volumeLevel - ((volumeLevel + level) - TV_MAX_VOLUME);
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ " + level + "��ŭ �� �ø��� " + 
								tempLevel + "��ŭ �÷� ���� �ִ�ġ�� �Ǿ����ϴ�.");
		}
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV ������ 1��ŭ ���� " + volumeLevel);
		} else {
			System.out.println("TV ������ �ּ�ġ���� ������ �� �߽��ϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������ " + level + "��ŭ ���� " + volumeLevel);
		} else { // ���� ������ 2. ������ 10��ŭ ������� �ϸ� 2��ŭ.
			int tempLevel = volumeLevel - TV_MIN_VOLUME;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������ " + level + " ��ŭ �� ������ " + 
								tempLevel + "��ŭ ���� �ּҺ����� �Ǿ����ϴ�.");
		}//if
	}
	
}// class
