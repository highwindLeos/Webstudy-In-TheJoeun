package com.tj.ex05tostring;

public class SawonTestMain {

	public static void main(String[] args) {
		Sawon kang = new Sawon("2345","������","�����");
		Sawon yu = new Sawon("23456","������","�񼭽�");
		
//		kang.print();
//		yu.print();
		
		// tostring �� �������̵� �ϸ� ��ü�� ��½� �⺻���� ����Լ��� �ҷ��´�. (�߿�)
		System.out.println(kang); // �⺻������ ��ü�� ����ϸ� toString() ���� ����Ѵ�.
		System.out.println(yu);   // �⺻������ ��ü�� ����ϸ� toString() ���� ����Ѵ�.		

	}

}
