package com.tj.Example;

//1+(1+2)+(1+2+3)+(1+2+3+4)... (1+2+3+4+5...10) = 220

public class Ex02 {

	public static void main(String[] args) {
		int n = 10;
		int total = 0; // 누적할때는 초기값이 있어야한다.

		for (int i = 1; i <= n; i++) {
			System.out.print("("); //여는 가로를 출력한다.
			for (int j = 1; j <= i; j++) {
				if (j == i) { // J가 i 같은 것은 마지막 계산.
					System.out.print(j);
				} else {
					System.out.print(j + "+");
				}
				total += j; // 누적
			}
			if (i != 10) {
				System.out.print(") + "); // 10번째 계산이 아닌경우만 ) + 로 출력.
			} else {
				System.out.print(") = "); // 10번째 계산이라면 ) = 로 출력
			}
		}
		System.out.println(total);
	}

}
