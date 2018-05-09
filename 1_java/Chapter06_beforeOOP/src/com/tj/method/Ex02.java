package com.tj.method;

public class Ex02 {

	public static void main(String[] args) {
		Ex02  ex02 = new Ex02(); // �Լ��� static �� ���ٸ� ��ü�� ���� �޸𸮿� �÷����Ѵ�.
		int sum = ex02.sum(1, 7); // �Ұ�ȣ�� ������ �޼ҵ� : ȣ��
		
		System.out.println("�������� " + sum);
		System.out.println(ex02.evenOdd(sum));
		
	}
	
	private int sum(int from, int to) {
		int resulte = 0;
		for (int i = from; i <= to; i++) { // from ���� to ���� ���� resulte �� ����.
			resulte += i;
		}

		return resulte; // ���� ��ȯ�ϰ� �Լ� ����.
	}

	private String evenOdd(int value) {
		String oddeven;
		if ((value % 2) == 0) {
			oddeven = "¦���Դϴ�.";
		} else {
			oddeven = "Ȧ���Դϴ�.";
		}

		return oddeven;
	}
}
