package com.tj.ex01string;

import java.util.Scanner;

public class StringEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 10;
		
		String str1 = new String("java"); // �̷��� �Ǵ� ���� 
		String str2 = "java"; // �̷��� �ǰ� ����� ���� ���� String ������ ������ ��ü
		
		String str01 = "Java";
		String str02 = "Java";
		String str03 = new String("Java");
		String str04 = new String("Java");
		
		if(str01 == str02) {
			System.out.println("str01 �� str02 �������� �����Ѵ�.");
		} else {
			System.out.println("�ٸ����� �����Ѵ�.");
		}
		
		 System.out.println( str1 == str2 ? "1�� 2�� �����ּ�" : "1�� 2�� �ٸ��ּ�");  
		 System.out.println(str01.equals(str02) ? "1�� 2�� �����ּ�" : "1�� 2�� �ٸ��ּ�");// equals() : �̰��� ���� ���Ѵ�.

		 System.out.println(str01 == str03 ? "1�� 3�� �����ּ�" : "1�� 3�� �ٸ��ּ�");
		 System.out.println(str01.equals(str03) ? "1�� 3�� �����ּ�" : "1�� 3�� �ٸ��ּ�");// equals() : �̰��� ���� ���Ѵ�.
	
		 System.out.println(str03 == str04 ? "3�� 4�� �����ּ�" : "3�� 4�� �ٸ� �ּ�");
		 System.out.println(str03.equals(str04) ? "3�� 4�� �����ּ�" : "3�� 4�� �ٸ� �ּ�");// equals() : �̰��� ���� ���Ѵ�.
	}
}
