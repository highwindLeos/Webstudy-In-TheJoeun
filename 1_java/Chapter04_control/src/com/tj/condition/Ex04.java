package com.tj.condition;

import java.util.Scanner;
// ���� �Է¹޾� ���� �� ���.

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("���� �Է��ϼ���.");
		int num = sc.nextInt();
		
		if (num >= 0) {
			System.out.println("�Է��� ��("+ num +")�� ���밪 : "+ num);
		} else {
			System.out.println("�Է��� ��("+ num +")�� ���밪 : "+ (-num));
		}
		sc.close();
	}

}
