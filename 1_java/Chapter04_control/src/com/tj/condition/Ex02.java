package com.tj.condition;

import java.util.Scanner;

//두수를 입력받아 최대값, 최소값을 츌력.
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("두개의 수를 입력해주세요. : 최소값과 최대값을 출력해줍니다.");
	
		System.out.println("첫 번째 수를 입력하세요.");
		int num1 = sc.nextInt();
		System.out.println("두 번째 수를 입력하세요.");
		int num2 = sc.nextInt();
		
		int max = 0, min = 0;
		
		if (num1 > num2) {
			max = num1; min = num2;
			System.out.printf("최대값은 %d, 최소값은 %d \n", max, min);
		} else if(num1 < num2) {
			max = num2; min = num1;
			System.out.printf("최대값은 %d, 최소값은 %d \n", max, min);
		} else {
			max = num1; min = num2;
			System.out.printf("두 수 %d , %d 은(는) 같습니다. \n", max, min);
		}
		sc.close();
	}
}
