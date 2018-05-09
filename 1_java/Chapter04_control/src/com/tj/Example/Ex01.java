package com.tj.Example;

// 1~20  부터 정수중에서 2 또는 3의 배수가 아닌수의 합. 결과 73
// if((i % 2) != 0 && (i %3) != 0);
public class Ex01 {

	public static void main(String[] args) {
		int num = 0;

		for (int i = 0; i <= 20; i++) { // 20까지 증가.
			if ((i % 2) != 0 && (i % 3) != 0) { // 나누어서 나머지가 0이 아닌것.(배수)
				num += i;
			}
		}
		System.out.println(num);
	}

}
