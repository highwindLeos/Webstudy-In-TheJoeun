package com.tj.ex09store;
// ���� 3ȣ
// ��ġ� : 6000�� �δ�� 7000�� ����� 7000�� ���뱹 6000��
public class Store3 extends HeadQuarterStore {
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 6,000�� �Դϴ�.");
	}
	
	@Override
	public void bude() {
		System.out.println("�δ�� : 7,000�� �Դϴ�.");
	}
	
	@Override
	public void bibim() {
		System.out.println("����� : 7,000�� �Դϴ�.");
	}
	
	@Override
	public void sunde() {
		System.out.println("���뱹 : 6,000�� �Դϴ�.");
	}
}
