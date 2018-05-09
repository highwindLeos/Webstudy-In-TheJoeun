package com.tj.ex2;

public class ManTestMain {

	public static void main(String[] args) {
		Man m1 = new Man();
		Man m2 = new Man(30, 178, 60, "010-0000-0000");
		Man m3 = new Man(160, 50);
		
		double bmi = m1.calcluateBMI();
		if (bmi > 24) {
			System.out.println("m1은 비만이니 다이어트 하세요");
		}
		
		bmi = m2.calcluateBMI();
		if (bmi > 24) {
			System.out.println("m2은 비만이니 다이어트 하세요");
		}
		
		bmi = m3.calcluateBMI();
		if (bmi > 24) {
			System.out.println("m3은 비만이니 다이어트 하세요");
		}
		
		
	    /*System.out.println("m1 나이 "+ m1.getAge());
		System.out.println("m1 키 "+ m1.getHeight());
		System.out.println("m1 몸무게 "+ m1.getWeight());
		System.out.println("m1 전번 " + m1.getPhonenumber());
		
		Man m2 = m1;
		
		if (m1.equals(m2)) {
			System.out.println("m1 과 m2 는 같다.");
		}else {
			System.out.println("m1 과 m2 는 다르다.");
		}*/

	}

}
