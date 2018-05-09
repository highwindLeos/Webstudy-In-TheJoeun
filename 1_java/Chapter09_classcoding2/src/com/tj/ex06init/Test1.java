package com.tj.ex06init;

public class Test1 {
	private int i = 1; // 코드에 직접 초기화 하는 법 (간혹 쓰게된다.)

	{
		i = 1; // 초기화 블럭을 통한 초기화.
	}

	public Test1() {
		i = 1; // 가장 많이 쓰는 변수 초기값 설정법.
	}

	public Test1(int i) {
		this.i = i;
	} // 생성자 함수에 매개변수로 값을 입력받아서 초기화.

}
