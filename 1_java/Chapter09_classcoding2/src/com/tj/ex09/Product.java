package com.tj.ex09;

public class Product {
	public static int count = 101;  //class ���� : ��� ��ü�� ������.
	private int serialNo;
	
	public Product() {
		serialNo = count++;
	}

	public int getSerialNo() {
		return serialNo;
	}

	
}
