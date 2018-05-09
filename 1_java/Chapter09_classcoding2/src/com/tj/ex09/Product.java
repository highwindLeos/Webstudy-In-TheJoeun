package com.tj.ex09;

public class Product {
	public static int count = 101;  //class 변수 : 모든 객체가 공유함.
	private int serialNo;
	
	public Product() {
		serialNo = count++;
	}

	public int getSerialNo() {
		return serialNo;
	}

	
}
