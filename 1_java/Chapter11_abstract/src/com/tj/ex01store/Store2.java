package com.tj.ex01store;

// ���� 2ȣ Ŭ����
// ��ġ�-5,000 �δ��-5,000 �����-5,000 ���뱹-5,000  �����-����
public class Store2 extends HeadQuarterStore{
	private String name = "2ȣ��";

	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000�� �Դϴ�.");
	}
	
	@Override
	public void bibim() {
		System.out.println("����� : 5,000�� �Դϴ�.");
	}
	
	@Override
	public void gonggibob() {
		System.out.println("����� : �����Դϴ�.");
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� : 5,000 �Դϴ�.");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 : 5,000 �Դϴ�.");
	}
	
	public String getName() {
		return name;
	}
	
}
