package com.tj.array;

public class Ex04 {
	public static void main(String[] args) {
		int i = 10;
		int j = i;
		System.out.println("i=" + i + ", j=" + j);
		j = 99;
		System.out.println("i=" + i + ", j=" + j);
		// ���� �۾��� ���۷��� ������ �غ���.
		System.out.println();

		int[] score = { 100, 10, 20, 30, 40, 50 };
		int[] s = score;
		// �ΰ��� �ݺ��� ����� ���� ���� ����Ѵ�. score �� s �迭�� ���� �ּ��̱� ����.
		for (int idx = 0; idx < s.length; idx++) {
			System.out.printf("s[%d] = %d\t score[%d] = %d\n", idx, s[idx], idx, score[idx]);
		}

		s[0] = 9;	s[2] = 9;	s[4] = 9;
		System.out.println("s�迭�� ������");
		for (int idx = 0; idx < s.length; idx++) {
			System.out.printf("s[%d] = %d\t score[%d] = %d\n", idx, s[idx], idx, score[idx]);
		}
	}

}
