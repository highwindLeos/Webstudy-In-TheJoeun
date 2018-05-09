package com.tj.condition;

import java.util.Scanner;

// 점수를 입력 받아서 학점을 출력하는 프로그램.
public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "Leo";

		System.out.println("점수를 입력해주세요.");
		int score = sc.nextInt();
		
		if (score >= 90 && score <= 100) {
			System.out.println("A학점 \t 잘했어요");
		} else if (score >= 80 && score <= 90) {
			System.out.println("B학점 \t 했긴했나?");
		} else if (score >= 70 && score <= 80) {
			System.out.println("C학점 \t 그다지?");
		} else if (score >= 60 && score <= 70) {
			System.out.println("D학점 \t 공부 안했지?!");
		} else if (score >= 0 && score <= 60) {
			System.out.println("F학점 \t 권총 맞혔다!?");
		} else {
			System.out.println("유효한 점수가 아닙니다.");
		}
		sc.close(); // 스캐너 닫음

	}

}
