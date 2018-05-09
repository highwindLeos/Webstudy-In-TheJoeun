package com.tj.ex09volume;

public class TV implements IVolume {
	private final int TV_MAX_VOLUME = 20; // 지역 상수. 해당 클레스에만 사용하도록 한다.
	private final int TV_MIN_VOLUME = 0;
	private int volumeLevel;

	@Override
	public void volumeUp() {
		if (volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1만큼 올려 " + volumeLevel);
		} else {
			System.out.println("TV 볼륨이 최대치여서 올리지 못 했습니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV 볼륨을 " + level + "만큼 올려서 " + volumeLevel);
		} else { // 현제 볼륨이 18일 때 볼륨을 10만큼 올린다고 하면 2
			// int tempLevel = volumeLevel - ((volumeLevel + level) - TV_MAX_VOLUME);
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 " + level + "만큼 못 올리고 " + 
								tempLevel + "만큼 올려 현제 최대치가 되었습니다.");
		}
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨을 1만큼 내려 " + volumeLevel);
		} else {
			System.out.println("TV 볼륨이 최소치여서 내리지 못 했습니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV 볼륨을 " + level + "만큼 내려 " + volumeLevel);
		} else { // 현제 볼륨이 2. 볼륨을 10만큼 내리라고 하면 2만큼.
			int tempLevel = volumeLevel - TV_MIN_VOLUME;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV 볼륨을 " + level + " 만큼 못 내리고 " + 
								tempLevel + "만큼 내려 최소볼륨이 되었습니다.");
		}//if
	}
	
}// class
