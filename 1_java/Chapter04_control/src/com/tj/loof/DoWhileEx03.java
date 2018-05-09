package com.tj.loof;

import java.util.Scanner;

// 컴퓨터가 뽑은 Lotto 번호 를 맟추는 게임.
//1단계 : 로또 번호가 su 보다 큰지 작은지 힌트.

public class DoWhileEx03 {

	public static void main(String[] args)  {
		// 0.0 <= Math.random() 실수 < 1
		// 0.0 <= Math.random()*45<45 
		// 0 <= (int)(Math.random()*45<45
		// 1 <= (int)(Math.random()*45)+1 < 46
		int lotto, userNum;
		lotto = (int)(Math.random()*45) + 1; //1~45
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Lotto 번호를 맟춰보세요. 1 ~ 45");
			userNum = sc.nextInt();
			
			if (userNum == lotto) {
				break;
			} else if(userNum > lotto) {
				System.out.print(userNum + "보다 작은 번호를 선택하세요.");
			} else if(userNum < lotto) {
				System.out.print(userNum +"보다 큰 번호를 선택하세요.");
			} 
		}while(true);
			System.out.println("맟추셨습니다!! Lotto  번호는 " + lotto + " 입니다.");
	}// main
}
