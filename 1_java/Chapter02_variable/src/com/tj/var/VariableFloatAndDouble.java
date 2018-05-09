package com.tj.var;

public class VariableFloatAndDouble {

	public static void main(String[] args) { // 실수형 변수를 선언.
		// 실수 값 저장
		double var1 = 3.14;
		// float var2 = 3.14; 컴파일 에러
		float var3 = 3.14F;
		
		// 정밀도 테스트
		double var4 = 0.1234567890123456789;
		float var5 = 0.1234567890123456789F;
		
		System.out.println("var1 : " + var1);
		System.out.println("var3 : " + var3);
		System.out.println("var4 : " + var4);
		System.out.println("var5 : " + var5);
		
		//e 사용하기 (10의 지수 표현)
		int var6 = 3000000;
		double var7 = 3e6; // 3000000
		float var8 = 3e6F; // 3000000
		double var9 = 2e-3; //소수점 3자리 0.002
		
		System.out.println("var6 : " + var6);
		System.out.println("var7 : " + var7);
		System.out.println("var8 : " + var8);
		System.out.println("var9 : " + var9);

	}

}
