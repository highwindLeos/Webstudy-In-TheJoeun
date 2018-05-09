package com.tj.ex13decimal;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		double num = 1234567.8989;
		String[] pattern = {"00,000,000,00000",
							"##,###,###,##",
							"0.0%"};
		
		for (int i = 0; i < pattern.length ; i++) {
			DecimalFormat df = new DecimalFormat(pattern[i]);
			System.out.println(df.format(num));
		}
		
		System.out.println();
		// 0 : 반드시 자리수 확보
		// # : 수가 있을때만 출력 (포멧 자리수보다 넘칠때 반올림)
		DecimalFormat df = new DecimalFormat("##,###,###.##"); // 10^6 승 소수점 아래 2자리 출력으로 포맷을 정한다.
		System.out.printf("%s", df.format(num));
	}

}
