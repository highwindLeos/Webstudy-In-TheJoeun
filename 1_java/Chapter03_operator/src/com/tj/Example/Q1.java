package com.tj.Example;

import java.util.Scanner;

//���� ���� 3 : �Է��� ���� 3�� ������� Ȯ���ϴ� ���α׷�.
public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		String resulte; 
		System.out.println("������ �Է����ּ���.");
		i = sc.nextInt();
		
		resulte = ((i % 3) == 0) ? "�Է��� ���� 3�� ����Դϴ�."
								 : "�Է��� ���� 3�� ����� �ƴմϴ�.";
		sc.close();
		System.out.println(resulte);
		
	}

}
