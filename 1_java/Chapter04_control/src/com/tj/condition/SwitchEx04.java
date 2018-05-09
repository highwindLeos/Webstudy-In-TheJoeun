package com.tj.condition;

import java.util.Scanner;

public class SwitchEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("지금 몇월인가요 : 1 ~ 12월");
		int month = sc.nextInt();
		
		switch(month) {
		case 12: case 1: case 2:
			System.out.println("겨울이네요 감기조심.!!"); break;
		case 3: case 4: case 5:
			System.out.println("봄이네요 미세먼지 조심!!"); break;
		case 6: case 7: case 8:
			System.out.println("여름이네요 바다가자!!"); break;
		case 9: case 10: case 11:
			System.out.println("가을이네요 단풍구경가요!!"); break;
		default:
			System.out.println("1 ~ 12 까지만 입력하라구.");
		}
		sc.close(); 
	}

}
