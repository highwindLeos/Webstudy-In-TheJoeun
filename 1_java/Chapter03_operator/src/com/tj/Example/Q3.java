package com.tj.Example;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1,num2; // �Է¹��� ���� ����
		String resulte; // ����� ���� ���ڿ� ����
		
		System.out.println(" ���� �������� �˾ƺ��ϴ�. �ΰ��� ������ ������� �Է����ּ���.");
		
		System.out.println(" ù��° �� �Է�");
		num1 = sc.nextInt();
		System.out.println(" �ι�° �� �Է�");
		num2 = sc.nextInt();
		
		resulte = (num1 == num2) ? "O : ���� ���Դϴ�." : "X : �ٸ� �� �Դϴ�.";
		System.out.println(resulte);
		
		sc.close(); // ��ĳ�� ��ü�� �ݴ´�.

	}

}
