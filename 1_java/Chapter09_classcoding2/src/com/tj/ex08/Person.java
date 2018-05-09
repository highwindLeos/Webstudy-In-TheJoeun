package com.tj.ex08;

public class Person {

	private String name;
	private int money;
	public static int COMM_MONEY; // static 공유되는 변수. 회사 공금.
	
	// 생성자
	public Person(String name) {
		this.name = name;
	}
	
	//class 함수.
	public void saveMoney(int money) {
		this.money += money; // this.money = money + money;
	}

	public void currentMoney() {
		System.out.println(name + " 님 사비 : " + money + "\n\t 공금은 :" + COMM_MONEY);
	}

}
