package com.tj.ex08;

public class Person {

	private String name;
	private int money;
	public static int COMM_MONEY; // static �����Ǵ� ����. ȸ�� ����.
	
	// ������
	public Person(String name) {
		this.name = name;
	}
	
	//class �Լ�.
	public void saveMoney(int money) {
		this.money += money; // this.money = money + money;
	}

	public void currentMoney() {
		System.out.println(name + " �� ��� : " + money + "\n\t ������ :" + COMM_MONEY);
	}

}
