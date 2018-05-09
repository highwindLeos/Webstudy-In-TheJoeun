package com.tj.condition;

import java.util.Scanner;

// 가위 = 0  바위 = 1 보 = 2 중 하나의 난수를 발생한다.
public class Ex06 {
	public static void main(String[] args) {
		// 기본 API
		// Math.random() : 0 ~ 1 사이의 double실수
		// Math.random()*3 : 0 < 3 사이의 double실수
		int computer = (int) (Math.random() * 3);

		if (computer == 0) {
			System.out.println("가위");
		} else if (computer == 1) {
			System.out.println("바위");
		} else if (computer == 2) {
			System.out.println("보");
		}
	}
}
