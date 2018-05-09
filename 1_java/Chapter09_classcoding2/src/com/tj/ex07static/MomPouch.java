package com.tj.ex07static;

public class MomPouch {

	public static int money = 200;
	// 이 변수는 static : 객체의 포함되지 않고 공유되는 메모리에 올라가고
	// 이것은 생성되는 객체가 모두 참조한다.
	public void test() {

	}

	/*
	 * public int getMoney() { return money; }
	 * 
	 * public void setMoney(int money) { this.money = money; }
	 */
}
