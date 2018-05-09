package com.tj.method;

// 1~10 까지 합을 출력하고 홀수 인지 짝수인지 출력. - Method 를 사용하지 않는 Logic
public class Ex01 {
	
	

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		} // 1~10 까지 합.
		
		System.out.println("1~10 까지 누접합은" + sum);
//		System.out.println((sum % 2) == 0 ? "짝수 입니다" : "홀수 입니다");

		if ((sum % 2) == 0) {
			System.out.println("짝수 입니다.");
		}else {
			System.out.println("홀수 입니다.");
		}
		
		sum = 0;
		for (int i = 5; i <= 50; i++) {
			sum += i;
		} // 5~50 까지 합.
		
		System.out.println("5~50 까지 누접합은" + sum);
//		System.out.println((sum % 2) == 0 ? "짝수 입니다" : "홀수 입니다");

		if ((sum % 2) == 0) {
			System.out.println("짝수 입니다.");
		}else {
			System.out.println("홀수 입니다.");
		}
		
	}

}
