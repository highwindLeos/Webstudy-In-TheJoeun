package com.tj.ex11mompouch;

public class Child {
	private String sun;

	// 생성자. 데이터 초기화 로 주로 사용됨.
	public Child(String sun) {
		this.sun = sun;
	}
	// 사용자 함수.
	public void takeMoney(int money) {
		if (MomPouch.MONEY >= money) { // 자식이 출금을 요구하는 돈이 엄마지갑의 돈보다 같거나 작아야 출금.
			System.out.println(sun + "이 " + money + "원 받았어요.");
			// Mompouch.MONEY = Mompouch.MONEY - money;
			MomPouch.MONEY -= money;
		} else {
			System.out.println(sun + "이 돈 못 받았어요. 엄마 지갑에 돈이 적어.");
		}
	}

}
