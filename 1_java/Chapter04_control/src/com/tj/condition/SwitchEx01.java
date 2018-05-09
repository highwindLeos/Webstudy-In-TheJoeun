package com.tj.condition;

import java.util.Scanner;

public class SwitchEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "Leo";

		System.out.println("점수를 입력해주세요.");
		int score = sc.nextInt();
		int temp = (score == 100) ? (score - 1) : score; // 임시 변수에서 100점일때를 처리한다.
		temp = (temp > -10 && temp < 0) ? (temp - 10) : temp; // 점수가 0이상 10이하 일때는 -10 해서 결과를 낸다.

		switch (temp / 10) { // 조건 입력은 정수나 문자나 문자열만 가능하다.
		case 9:
			System.out.println("A학점 입니다. 잘했어요");
			break;
		case 8:
			System.out.println("B학점 입니다. 좀 했군요");
			break;
		case 7:
			System.out.println("C학점 입니다. 그다지...");
			break;
		case 6:
			System.out.println("D학점 입니다. 공부좀 해");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("F학점 입니다. 잘했어요");
			break;
		default:
			System.out.println("유효한 점수가 아닙니다.");
		}
		// switch 문으로 바꾼 if 문법
		/*
		 * if (score >= 90 && score <= 100) { System.out.println("A학점 \t 잘했어요"); } else
		 * if (score >= 80 && score <= 90) { System.out.println("B학점 \t 했긴했나?"); } else
		 * if (score >= 70 && score <= 80) { System.out.println("C학점 \t 그다지?"); } else
		 * if (score >= 60 && score <= 70) { System.out.println("D학점 \t 공부 안했지?!"); }
		 * else if (score >= 0 && score <= 60) { System.out.println("F학점 \t 권총 맞혔다!?");
		 * } else { System.out.println("유효한 점수가 아닙니다."); }
		 */
		sc.close(); // 스캐너 닫음

	}

}
