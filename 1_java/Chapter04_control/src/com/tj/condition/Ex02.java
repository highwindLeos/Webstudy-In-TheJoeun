package com.tj.condition;

import java.util.Scanner;

//�μ��� �Է¹޾� �ִ밪, �ּҰ��� ����.
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("�ΰ��� ���� �Է����ּ���. : �ּҰ��� �ִ밪�� ������ݴϴ�.");
	
		System.out.println("ù ��° ���� �Է��ϼ���.");
		int num1 = sc.nextInt();
		System.out.println("�� ��° ���� �Է��ϼ���.");
		int num2 = sc.nextInt();
		
		int max = 0, min = 0;
		
		if (num1 > num2) {
			max = num1; min = num2;
			System.out.printf("�ִ밪�� %d, �ּҰ��� %d \n", max, min);
		} else if(num1 < num2) {
			max = num2; min = num1;
			System.out.printf("�ִ밪�� %d, �ּҰ��� %d \n", max, min);
		} else {
			max = num1; min = num2;
			System.out.printf("�� �� %d , %d ��(��) �����ϴ�. \n", max, min);
		}
		sc.close();
	}
}
