package com.tj.ex2;

public class ManTestMain2 {

	public static void main(String[] args) {

		/*
		 * int [] iArr = new int[3]; iArr[0] = 0; iArr[1] = 2;
		 */
		// Man[] m = new Man[3]; // 객체 배열이 생성된다. 오브젝트는 아직 만들지 않은 상태.
		// int[] iArr = { 0, 1, 2 };

		Man[] m = { new Man(), new Man(18, 178, 60, "010-0000-0000"), new Man(160, 50) };
		// m 이란 변수는 레퍼런스 변수라고 한다. (참조 변수) = 객체 , 인스턴스.

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
				System.out.println("m[" + i + "] 은(는) 비만이니 다이어트 해라.");
			}
		}

		/*
		 * double bmi = m1.calcluateBMI(); if (bmi > 24) {
		 * System.out.println("m1은 비만이니 다이어트 하세요"); }
		 * 
		 * bmi = m2.calcluateBMI(); if (bmi > 24) {
		 * System.out.println("m2은 비만이니 다이어트 하세요"); }
		 * 
		 * bmi = m3.calcluateBMI(); if (bmi > 24) {
		 * System.out.println("m3은 비만이니 다이어트 하세요"); }
		 */

		/*
		 * System.out.println("m1 나이 "+ m1.getAge()); System.out.println("m1 키 "+
		 * m1.getHeight()); System.out.println("m1 몸무게 "+ m1.getWeight());
		 * System.out.println("m1 전번 " + m1.getPhonenumber());
		 * 
		 * Man m2 = m1;
		 * 
		 * if (m1.equals(m2)) { System.out.println("m1 과 m2 는 같다."); }else {
		 * System.out.println("m1 과 m2 는 다르다."); }
		 */

	}

}
