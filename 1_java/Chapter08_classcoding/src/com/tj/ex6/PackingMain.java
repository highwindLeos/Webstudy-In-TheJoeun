package com.tj.ex6;

public class PackingMain {

	public static void main(String[] args) {
		Packing car1 = new Packing("11�� 1111", 8);
		Packing car2 = new Packing("22�� 2222", 9);
		
		Packing.HOURLYPARKINGRATE += 200; // ��������� �÷ȴ�.

		car1.setOutTime(10);
		car1.outPrint();

		car2.setOutTime(11);
		car2.outPrint();

		Packing car3 = new Packing();

		car3.setCarNum("33�� 3333");
		car3.setInTime(11);

		car3.setOutTime(17);
		car3.outPrint();
	}

}
