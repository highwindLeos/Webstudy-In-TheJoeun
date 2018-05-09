package com.tj.ex04math;

public class Lotto2 {

	public static void main(String[] args) {
	
		int Lotto[] = new int[7];
		
		System.out.print("Lotto 선택 숫자는 ");
		
		for(int i=0; i < Lotto.length; i++){
			Lotto[i] = (int)(Math.random()*45)+1; // Random 함수 를 이용한 난수 (1~45)
			for(int j = i - 1; j >= 0; j--){
				if(Lotto[i] == Lotto[j]){
					i--;
					break;
				}
			}
		}// 중복 값 제거2
		// 출력
		for(int i=0; i < Lotto.length; i++){
			System.out.print(Lotto[i] + " ");
		}
		System.out.print("보너스 숫자는 " + Lotto[6] + "입니다.");
	}
	
}