package com.tj.ex07clone;

public class RectangleTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle rc1 = new Rectangle(8, 9);
		Rectangle rc2 = (Rectangle)rc1.clone(); // ���� : �ּҰ� �޶��� ������ ���� ��ü�� �����.
		Rectangle rc3 = rc1; // ��ü�� ��� �ִ� �ּҵ� ����.
		
		if (rc1 == rc3) {
			System.out.println("r3�� r1 ������ �� �ƴϳ�");
		}
		
		if (rc1 == rc2) {
			System.out.println("r2�� r1 ������ �� �ƴϳ�");
		} else {
			System.out.println("r2�� r1 �ּҰ� �ٸ���");
		}
		
		System.out.println("rc1 : "+ rc1); // �������̵� �� toString() ���� ��µ�.
		System.out.println("rc2 : "+ rc2);
		
		if(rc1.equals(rc2)) {
			System.out.println("���� ���");
		} else {
			System.out.println("�ٸ� ���");
		}
		
	}

}
