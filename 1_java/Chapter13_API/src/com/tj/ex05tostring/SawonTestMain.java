package com.tj.ex05tostring;

public class SawonTestMain {

	public static void main(String[] args) {
		Sawon kang = new Sawon("2345","강동원","전산실");
		Sawon yu = new Sawon("23456","유아인","비서실");
		
//		kang.print();
//		yu.print();
		
		// tostring 을 오버라이드 하면 객체를 출력시 기본적인 출력함수로 불러온다. (중요)
		System.out.println(kang); // 기본적으로 객체를 출력하면 toString() 으로 출력한다.
		System.out.println(yu);   // 기본적으로 객체를 출력하면 toString() 으로 출력한다.		

	}

}
