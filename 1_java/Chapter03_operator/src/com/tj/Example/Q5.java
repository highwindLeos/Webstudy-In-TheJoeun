package com.tj.Example;

import java.util.Scanner;

public class Q5 { //�ֹι�ȣ 7��° �ڸ��� �Է��ؼ� �������� �������� ����ϴ� ����.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("�ֹ� ��ȣ 7��° �ڸ��� �Է����ּ���.");
		int num = sc.nextInt();
		
		if (num == 1 || num == 3) {
			System.out.println("�����Դϴ�.");
		} else if (num == 2 || num == 4) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("�ֹι�ȣ 7��°�� 1,2,3,4 �� �ü� �ֽ��ϴ�.");
		}
		
	}

}
