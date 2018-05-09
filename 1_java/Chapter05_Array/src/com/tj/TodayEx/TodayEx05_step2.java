package com.tj.TodayEx;
// 2단계 : 배열을 이용하여 학생들 (영희 철수 길동 영수 말자)의 키를 입력받아 

// 최단신과 최장식 출력

import java.util.Scanner;

public class TodayEx05_step2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = { "영희", "철수", "길동", "영수", "말자" };
		int[] height = new int[name.length]; // 키 배열의 인덱스 길이는 학생의 수와 같다.

		int max = 0; // 최대값 변수 , 주로 작은 수로 초기화
		int maxIndex = 0;
		int min = 999; // 최소값 변수, 큰 수로 초기화
		int minIndex = 0; 

		for (int i = 0; i < name.length; i++) {

			System.out.println(name[i] + "의 키는?");
			height[i] = sc.nextInt();

		}
		// 5명의 키를 height 배열 방에 넣음
		for (int i = 0; i < name.length; i++) {
			if (max < height[i]) {
				max = height[i];
				maxIndex = i; // name 의 인덱스를 저장
			} // end if
			if (min > height[i]) {
				min = height[i];
				minIndex = i; // name 의 인덱스를 저장
			} // end if
		} // end for
		System.out.println("최장신 : " + max + "(" + name[maxIndex] + ") 입니다.");
		System.out.println("최단신 : " + min + "(" + name[minIndex] + ") 입니다.");
		
		sc.close();
	}
}
