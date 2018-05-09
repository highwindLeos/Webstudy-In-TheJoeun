package com.tj.var;

public class Ex05 {

	public static void main(String[] args) {

		int i1 = 10;
		long l1 = 22000000000L;
		
		// 형변환 = 1. 묵시적인 형변환 2. 명시적 형변환.
		l1 = i1; // 자바가 알아서 4바이트 자료를 8바이트로 변환해준다.
		
		double d1 = 10.91;
		i1 = (int)d1; //큰주머니의 데이터를 작은 주머니로 넣을 때. (cascading)
		
		System.out.println("10.91을 int로 형변환 : " + i1);
		
	}

}
