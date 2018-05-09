package com.tj.ex10staticfinal;

import com.tj.staticfinal.PiClass;

public class MainClass {

	public static void main(String[] args) {
		double area = 2 * 2 * PiClass.PI;
		System.out.println("반지름이 2인 원의 넓이는 " + area);
		// PiClass.PI = 3.14; final 변수는 값 수정 불가.
	}

}
