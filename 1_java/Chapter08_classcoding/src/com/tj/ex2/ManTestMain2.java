package com.tj.ex2;

public class ManTestMain2 {

	public static void main(String[] args) {

		/*
		 * int [] iArr = new int[3]; iArr[0] = 0; iArr[1] = 2;
		 */
		// Man[] m = new Man[3]; // ��ü �迭�� �����ȴ�. ������Ʈ�� ���� ������ ���� ����.
		// int[] iArr = { 0, 1, 2 };

		Man[] m = { new Man(), new Man(18, 178, 60, "010-0000-0000"), new Man(160, 50) };
		// m �̶� ������ ���۷��� ������� �Ѵ�. (���� ����) = ��ü , �ν��Ͻ�.

		m[0] = new Man();
		m[0].setHeight(160);
		m[0].setWeight(100);
		//	m[1] = new Man(30, 178, 60, "010-0000-0000");
		//	m[2] = new Man(170, 50);

		/*
		 * Man m1 = new Man(); Man m2 = new Man(30, 178, 60, "010-0000-0000"); Man m3 =
		 * new Man(160, 50);
		 */
		double bmi;
		for (int i = 0; i < m.length; i++) {
			bmi = m[i].calcluateBMI();
			if (bmi > 24) {
				System.out.println("m[" + i + "] ��(��) ���̴� ���̾�Ʈ �ض�.");
			}
		}

		/*
		 * double bmi = m1.calcluateBMI(); if (bmi > 24) {
		 * System.out.println("m1�� ���̴� ���̾�Ʈ �ϼ���"); }
		 * 
		 * bmi = m2.calcluateBMI(); if (bmi > 24) {
		 * System.out.println("m2�� ���̴� ���̾�Ʈ �ϼ���"); }
		 * 
		 * bmi = m3.calcluateBMI(); if (bmi > 24) {
		 * System.out.println("m3�� ���̴� ���̾�Ʈ �ϼ���"); }
		 */

		/*
		 * System.out.println("m1 ���� "+ m1.getAge()); System.out.println("m1 Ű "+
		 * m1.getHeight()); System.out.println("m1 ������ "+ m1.getWeight());
		 * System.out.println("m1 ���� " + m1.getPhonenumber());
		 * 
		 * Man m2 = m1;
		 * 
		 * if (m1.equals(m2)) { System.out.println("m1 �� m2 �� ����."); }else {
		 * System.out.println("m1 �� m2 �� �ٸ���."); }
		 */

	}

}
