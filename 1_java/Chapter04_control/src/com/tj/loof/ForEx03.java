package com.tj.loof;

// 15 ~ 50 ���� ���ٿ� 5�� �� ���.
public class ForEx03 {
	public static void main(String[] args) {
		for (int i = 15; i <= 50; i++) {

			if ((i % 5) == 4) { // 5�� ���������� (���� 4 9) ��� �ٹٲ�.
				System.out.print(i + "\n");
			} else {
				System.out.print(i + "\t");
			} // end if
			
		} // end for
	} // main
} // class