package com.tj.ex09;

public class ProductMain {

	public static void main(String[] args) {
		System.out.println("count : " + Product.count);

		Product p1 = new Product();

		System.out.println("p1 �ø��� �ѹ��� : " + p1.getSerialNo());
		System.out.println("count : " + Product.count);

		Product p2 = new Product();

		System.out.println("p1 �ø��� �ѹ��� : " + p1.getSerialNo());
		System.out.println("p2 �ø��� �ѹ��� : " + p2.getSerialNo());
		System.out.println("count : " + Product.count);

		Product p3 = new Product();

		System.out.println("p1 �ø��� �ѹ��� : " + p1.getSerialNo());
		System.out.println("p2 �ø��� �ѹ��� : " + p2.getSerialNo());
		System.out.println("p3 �ø��� �ѹ��� : " + p3.getSerialNo());
		System.out.println("count : " + Product.count);
	}

}
