package com.tj.op;

public class Ex01 {
	
	public static void main(String[] args) {
		System.out.println("== ��� ������ ==");
		int n1 = 33, n2 = 10;
		int resulte;
		double resulteDouble;
		
		resulte = n1 + n2; // ���ϱ� ����
		System.out.printf("%d %c %d = %d \n", n1, '+', n2, resulte);
		
		resulte = n1 - n2; // ���� ����
		System.out.printf("%d %c %d = %d \n", n1, '-', n2, resulte);
		
		resulte = n1 * n2; // ���ϱ� ����
		System.out.printf("%d %c %d = %d \n", n1, '*', n2, resulte);
		
		resulte = n1 / n2; // ������ ����
		System.out.printf("%d %c %d = %d \n", n1, '/', n2, resulte);
		
		resulteDouble = (double)n1 / n2; // ������ ���� (�Ǽ��� ��� ����� ��ȯ)
		System.out.printf("%d %c %d = %3.1f \n", n1, '/', n2, resulteDouble);
		
		resulte = n1 % n2; // ������ ���� ������ ��.
		System.out.printf("%d %c %d = %d \n", n1, '%', n2, resulte);
		
		resulteDouble = n1 / 0.0; //0 ���� ������ ���ܰ� �߻�. 
		System.out.println("Test");
		System.out.printf("%d %c %f = %f\n",n1, '/', 0.0, resulteDouble); // �ش����� ���ѿ� ����� �� Infinity ���.
		
		resulteDouble = n1 % 0.0;
		System.out.println("Test");
		System.out.printf("%d %c %f = %f\n", n1, '%', 0.0, resulteDouble); // �ش����� '���� �ƴ� ��' NaN ���.
		
		if ((n1 % 2) == 0) { 
			System.out.println("n1 �� ¦���Դϴ�.");
		} else {
			System.out.println("n1 �� Ȧ���Դϴ�.");
		}
		
		if ((n1 % 5) == 0) {
			System.out.println("n1 �� 5�� ��� �Դϴ�.");
		} else {
			System.out.println("n1 �� 5�� ����� �ƴմϴ�.");
		}

	}
	
}
