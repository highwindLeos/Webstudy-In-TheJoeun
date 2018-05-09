package com.tj.ex01string;

import java.util.Scanner;

public class StringEx02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String fn = "";
		System.out.print("원하는 거 눌러 (j : 가위 , u : 수정, x : 종료)");
		fn = sc.next();
		if(fn.equalsIgnoreCase("x")) { //fn.equals("x")|| fn.equals("X")
			System.out.println("종료를 원하네. 안녕.");
		}
		
		sc.close();
	}

}
