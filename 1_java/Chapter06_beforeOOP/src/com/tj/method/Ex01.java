package com.tj.method;

// 1~10 ���� ���� ����ϰ� Ȧ�� ���� ¦������ ���. - Method �� ������� �ʴ� Logic
public class Ex01 {
	
	

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		} // 1~10 ���� ��.
		
		System.out.println("1~10 ���� ��������" + sum);
//		System.out.println((sum % 2) == 0 ? "¦�� �Դϴ�" : "Ȧ�� �Դϴ�");

		if ((sum % 2) == 0) {
			System.out.println("¦�� �Դϴ�.");
		}else {
			System.out.println("Ȧ�� �Դϴ�.");
		}
		
		sum = 0;
		for (int i = 5; i <= 50; i++) {
			sum += i;
		} // 5~50 ���� ��.
		
		System.out.println("5~50 ���� ��������" + sum);
//		System.out.println((sum % 2) == 0 ? "¦�� �Դϴ�" : "Ȧ�� �Դϴ�");

		if ((sum % 2) == 0) {
			System.out.println("¦�� �Դϴ�.");
		}else {
			System.out.println("Ȧ�� �Դϴ�.");
		}
		
	}

}
