package com.tj.array;

public class Ex03 {
	public static void main(String[] args) {
		// 3. 배열 선언과 공간 확보와 초기화를 별도로
		int[] arr; // 배열 변수만 선언.
//		arr[0] =100; //공간 확보가 안되어서 컴파일 조차 되지 않는다.
		
		arr = new int[3]; // 배열 공간 확보
		arr[0] = 100; arr[1] = 200; arr[2] = 300; //값을 할당
		
		for (int a : arr) {
			System.out.print(a + "\t");
		}
		
	}

}
