package com.tj.ex01string;

import java.util.Scanner;

public class StringEx02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String fn = "";
		System.out.print("���ϴ� �� ���� (j : ���� , u : ����, x : ����)");
		fn = sc.next();
		if(fn.equalsIgnoreCase("x")) { //fn.equals("x")|| fn.equals("X")
			System.out.println("���Ḧ ���ϳ�. �ȳ�.");
		}
		
		sc.close();
	}

}
