package com.tj.TodayEx;
// 3단계 : 입력을 받아서 오름 차순 정렬후 출력하라. 

import java.util.Scanner;

public class TodayEx05_step3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = { "영희", "철수", "길동", "영수", "말자" };
		int[] height = new int[name.length]; // 키 배열의 인덱스 길이는 학생의 수와 같다.

		for (int i = 0; i < name.length; i++) {

			System.out.println(name[i] + "의 키는?");
			height[i] = sc.nextInt();

		}

		for (int i = 0; i < name.length; i++) {
			System.out.print(height[i] + "(" + name[i] + ") ");
		}

		for (int i = 0; i < name.length; i++) { // 정렬하기.
			for (int j = i + 1; j < name.length; j++) { // 두번째 배열.
				if (height[i] > height[j]) {
					// 키를 정렬해준다.
					int tempH = height[i];
					height[i] = height[j];
					height[j] = tempH;
					// 이름도 정렬해준다.
					String tempN = name[i];
					name[i] = name[j];
					name[j] = tempN;
				} // if end
			} // for - j
		} // for - i
		System.out.println();
		for (int i = 0; i < name.length; i++) {
			System.out.print(height[i] + "(" + name[i] + ") ");
		}
		sc.close();
	}
}
