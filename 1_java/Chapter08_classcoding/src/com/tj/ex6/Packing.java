package com.tj.ex6;

// ������ ������ ������ ���
public class Packing {
	public static int HOURLYPARKINGRATE = 2000;
	
	private String carNum;
	private int inTime;
	private int outTime;
	private int price;

	public Packing() {
		System.out.println("�����ð��� �Էµ��� �ʾҽ��ϴ�.");
	}

	public Packing(String carNum, int inTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.price = HOURLYPARKINGRATE;
		System.out.println(carNum + "�� �������. �����ð� : " + inTime + "�� �Դϴ�. ��������� �ð� �� " + price + " ��");
	}

	// user method
	public void outPrint() {
		price = (outTime - inTime) * HOURLYPARKINGRATE;
		System.out.printf("���� �ϼ̽��ϴ�.\n ����ȣ*** %s *** \n �����ð� %d��\n �����ð� %d��\n ������� %d�� \n", 
							carNum, inTime, outTime, price);
		System.out.println();
	}

	// getter setter
	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
