package com.tj.loof;

import java.util.Scanner;

// 컴퓨터가 뽑은 Lotto 번호 를 맟추는 게임.
// 2단계 : .
public class DoWhileEx04 {

	public static void main(String[] args) {
		// 0.0 <= Math.random() 실수 < 1
		// 0.0 <= Math.random()*45<45
		// 0 <= (int)(Math.random()*45<45
		// 1 <= (int)(Math.random()*45)+1 < 46
		int lotto, userNum;
		int min = 1, max = 45; // 최소값 최대값

		lotto = (int) (Math.random() * 45) + 1; // 1~45

		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Lotto 번호를 맟춰보세요." + min + " 부터 " + max + "까지 입력해주세요.");
			userNum = sc.nextInt();
			
			if(userNum < min || userNum > max) {
				System.out.println("범위 안에 값을 입력하세요.");
			}else if (userNum == lotto) {
				break;
			} else if (userNum > lotto) {
				max = userNum - 1;
			} else if (userNum < lotto) {
				min = userNum + 1;
			}
		} while (true);
		System.out.println("맟추셨습니다!! Lotto  번호는 " + lotto + " 입니다.");
	}// main
}
