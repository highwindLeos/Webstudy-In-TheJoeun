package com.tj.rect;

// �簢���� ���� ���� �ʺ� ���ϴ� ���α׷�.
public class RectMain {

	public static void main(String[] args) {

		Rect rect1 = new Rect();

		rect1.setWidth(10);
		rect1.setHeigth(5);

		System.out.println("�簢���� ���δ� " + rect1.getWidth());
		System.out.println("�簢���� ���δ� " + rect1.getHeight());
		System.out.println("�簢���� ���̴� " + rect1.area());
		System.out.println();
		
		Rect rect2 = new Rect(10,5);
		
		//rect2.setWidth(10);
		//rect2.setHeigth(5);

		System.out.println("�簢���� ���δ� " + rect2.getWidth());
		System.out.println("�簢���� ���δ� " + rect2.getHeight());
		System.out.println("�簢���� ���̴� " + rect2.area());
		System.out.println();

		int i = 10, j = 10;
		if (i == j)
			System.out.println("i �� j �� ����.");
		if (rect1.equals(rect2)) // equals() ������Ʈ�� ������. ������ true �ٸ��� false
			System.out.println("rect1 �� rect2 �� ����.");
		else
			System.out.println("rect1 �� rect2 �� �ٸ���.");
	}

}
