package com.tj.ex2;

public class ManTestMain {

	public static void main(String[] args) {
		Man m1 = new Man();
		Man m2 = new Man(30, 178, 60, "010-0000-0000");
		Man m3 = new Man(160, 50);
		
		double bmi = m1.calcluateBMI();
		if (bmi > 24) {
			System.out.println("m1�� ���̴� ���̾�Ʈ �ϼ���");
		}
		
		bmi = m2.calcluateBMI();
		if (bmi > 24) {
			System.out.println("m2�� ���̴� ���̾�Ʈ �ϼ���");
		}
		
		bmi = m3.calcluateBMI();
		if (bmi > 24) {
			System.out.println("m3�� ���̴� ���̾�Ʈ �ϼ���");
		}
		
		
	    /*System.out.println("m1 ���� "+ m1.getAge());
		System.out.println("m1 Ű "+ m1.getHeight());
		System.out.println("m1 ������ "+ m1.getWeight());
		System.out.println("m1 ���� " + m1.getPhonenumber());
		
		Man m2 = m1;
		
		if (m1.equals(m2)) {
			System.out.println("m1 �� m2 �� ����.");
		}else {
			System.out.println("m1 �� m2 �� �ٸ���.");
		}*/

	}

}
