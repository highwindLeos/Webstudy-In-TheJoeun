package com.tj.method;

public class Ex02 {

	public static void main(String[] args) {
		Ex02  ex02 = new Ex02(); // 함수에 static 이 없다면 객체로 만들어서 메모리에 올려야한다.
		int sum = ex02.sum(1, 7); // 소괄호가 있으면 메소드 : 호출
		
		System.out.println("누적합은 " + sum);
		System.out.println(ex02.evenOdd(sum));
		
	}
	
	private int sum(int from, int to) {
		int resulte = 0;
		for (int i = from; i <= to; i++) { // from 부터 to 까지 합을 resulte 에 누적.
			resulte += i;
		}

		return resulte; // 값을 반환하고 함수 종료.
	}

	private String evenOdd(int value) {
		String oddeven;
		if ((value % 2) == 0) {
			oddeven = "짝수입니다.";
		} else {
			oddeven = "홀수입니다.";
		}

		return oddeven;
	}
}
