package com.tj.condition;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위 바위 보를 선택하세요 : 가위 (0) , 바위 (1), 보 = (2)");
		int human = sc.nextInt();

		if (human == 0) {
			System.out.println("가위");
		} else if (human == 1) {
			System.out.println("바위");
		} else if (human == 2) {
			System.out.println("보");
		} else {
			System.out.println("0 ~ 2 사이의 정수만 입력해주세요.");
		}
		sc.close();
	}
}
