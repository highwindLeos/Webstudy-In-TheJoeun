package com.tj.var;

public class Ex03 {

	public static void main(String[] args) {
		float f; // 4 byte 메모리 공간에 라는 이름의 실수 주머니에 넣다.
		f = 10.1F; // 실수형에  float F 나 f 를 붙여서 넣어야한다.
		
		int i; // 4byte 메모리 공간에 i라는 이름의 정수 주머니에 넣다.
		i = 10; 
		
		System.out.println(i);
		
		long l; //8byte 메모리 공간을 l 이라는 공간의 큰정수 주머니에 넣다.
		l = 2200000000l;
		
		f = (float)10.0000017; // double 형을 float 으로 데이터 형을 변환한다.
		double d = 10.0000017;
		System.out.println("f = " + f + "\t d = " +d);
		
		if (f == d) { // 4바이트에 넣은 값과 8바이트의 넣은 값은 다른값이다. false.
			System.out.println("f와 d 는 같다.");
		} else  {
			System.out.println("f와 d 는 다르다.");
		}
	}

}
