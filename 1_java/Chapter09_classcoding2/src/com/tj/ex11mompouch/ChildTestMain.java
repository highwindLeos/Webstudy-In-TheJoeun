package com.tj.ex11mompouch;

public class ChildTestMain {

	public static void main(String[] args) {
		System.out.println("���� ���� :" + MomPouch.MONEY + " ��");
//		MomPouch m = new MomPouch();
//		System.out.println("���� ���� :" + m.MONEY + " ��");  // static �� �� ��ü�� �������� �ʾƵ� �ȴٰ� ��� ������.	
		
		Child first = new Child("ù°�Ƶ� Lee");
		Child second = new Child("��°�Ƶ� Im");
		Child third = new Child("��°�Ƶ� Non");

		first.takeMoney(100);
		System.out.println("�ܾ� : " + MomPouch.MONEY);
		
		second.takeMoney(100);
		System.out.println("�ܾ� : " + MomPouch.MONEY);
		
		third.takeMoney(100);
		System.out.println("�ܾ� : " + MomPouch.MONEY);

	}

}
