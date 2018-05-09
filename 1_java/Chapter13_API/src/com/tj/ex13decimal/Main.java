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
		// 0 : �ݵ�� �ڸ��� Ȯ��
		// # : ���� �������� ��� (���� �ڸ������� ��ĥ�� �ݿø�)
		DecimalFormat df = new DecimalFormat("##,###,###.##"); // 10^6 �� �Ҽ��� �Ʒ� 2�ڸ� ������� ������ ���Ѵ�.
		System.out.printf("%s", df.format(num));
	}

}
