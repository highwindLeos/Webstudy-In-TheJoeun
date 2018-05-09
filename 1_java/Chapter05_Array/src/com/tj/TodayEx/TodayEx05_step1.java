package com.tj.TodayEx;
// 1단계 : 배열을 이용하여 학생들 (영희 철수 길동 영수 말자)의 키를 입력받아 평균 출력

import java.util.Scanner;

public class TodayEx05_step1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = { "영희", "철수", "길동", "영수", "말자" };
		int[] height = new int[name.length]; // 키 배열의 인덱스 길이는 학생의 수와 같다.

		int total = 0; // 합계 변수
		double avg; // 평균 변수

		for (int i = 0; i < name.length; i++) {

			System.out.println(name[i] + "의 키는?");
			height[i] = sc.nextInt();

			total += height[i]; // 입력받은 키를 누적
		}

		avg = (double) total / (name.length); // 평균을 계산.

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " 의 키 :" + height[i] + " 입니다.");
		}
		System.out.printf("평균키는 %.1f ", avg);
		
		sc.close();
	}

}
