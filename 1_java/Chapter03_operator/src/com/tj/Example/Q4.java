package com.tj.Example;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age;
		String resulte;
		
		System.out.println("��� ���������� Ȯ���մϴ�. ���̸� �Է��ϼ���.");
		age = sc.nextInt();
		
		resulte =  (age >= 65) ? "65 �� �̻��Դϴ�. ���": "65�� �����Դϴ�. �Ϲ�";
		System.out.println(resulte);
		
		sc.close();

	}

}
