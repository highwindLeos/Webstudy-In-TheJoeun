package com.tj.ex07static;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("���� ���� ���� " + MomPouch.money);
		
		Child first = new Child("ù°�Ƶ�");
		Child second = new Child("��°�Ƶ�");
		Child third = new Child("��°�Ƶ�");
		
		first.takeMoney(100);
		System.out.println("���� ���� ���� " + MomPouch.money);
		second.takeMoney(100);
		System.out.println("���� ���� ���� " + MomPouch.money);
		third.takeMoney(100);
		System.out.println("���� ���� ���� " + MomPouch.money);

	}

}
