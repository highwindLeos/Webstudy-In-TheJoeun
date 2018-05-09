package com.tj.ex09;

public class ProductMain {

	public static void main(String[] args) {
		System.out.println("count : " + Product.count);

		Product p1 = new Product();

		System.out.println("p1 시리얼 넘버는 : " + p1.getSerialNo());
		System.out.println("count : " + Product.count);

		Product p2 = new Product();

		System.out.println("p1 시리얼 넘버는 : " + p1.getSerialNo());
		System.out.println("p2 시리얼 넘버는 : " + p2.getSerialNo());
		System.out.println("count : " + Product.count);

		Product p3 = new Product();

		System.out.println("p1 시리얼 넘버는 : " + p1.getSerialNo());
		System.out.println("p2 시리얼 넘버는 : " + p2.getSerialNo());
		System.out.println("p3 시리얼 넘버는 : " + p3.getSerialNo());
		System.out.println("count : " + Product.count);
	}

}
