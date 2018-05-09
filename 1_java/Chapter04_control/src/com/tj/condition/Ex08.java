package com.tj.condition;
// 당신과 컴퓨터가 가위 바위 보 내서 누가 이겼는지 출력.

import java.util.Scanner;

// 나는 뭘냈고 컴퓨터는 뭘냈는지 출력도 해준다. 
public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위 바위 보를 선택하세요 : 가위 (0) , 바위 (1), 보 = (2)");
		int human = sc.nextInt();
		
		String humanCrad="";
		String computerCard="";
		
		if (human == 0) {
			humanCrad = "가위";
		} else if (human == 1) {
			humanCrad = "바위";
		} else if (human == 2) {
			humanCrad = "보";
		} else {
			System.out.println("0~2 사이의 수만 입력해주세요");
			System.exit(0);
		}
		// Math.random() : 0 ~ 1 사이의 double실수
		// Math.random()*3 : 0 < 3 사이의 double실수
		int computer = (int)(Math.random() * 3); //0~3 사이의 정수
		
		if (computer == 0) {
			computerCard = "가위";
		} else if (computer == 1) {
			computerCard = "바위";
		} else if (computer == 2) {
			computerCard = "보";
		} 

		if ((human + 2) % 3 == computer) {
			System.out.printf("당신은 : %s \n컴퓨터는 : %s , \n당신이 이겼습니다.",humanCrad ,computerCard);
		} else if( human == computer ) {
			System.out.printf("당신은 : %s \n컴퓨터는 : %s , \n우리는 비겼습니다.",humanCrad ,computerCard);
		} else {
			System.out.printf("당신은 : %s \n컴퓨터는 : %s , \n당신이 졌습니다.(컴퓨터 승)",humanCrad ,computerCard);
		}
		
		sc.close();
	}
}
