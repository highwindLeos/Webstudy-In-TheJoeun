package com.tj.ex01store;
// ���� 1ȣ Ŭ����
// ��ġ�-4,500 �δ��-5,000 �����-6,000 ���뱹-���Ⱦ� �����-1,000��
public class Store1 extends HeadQuarterStore{
	private String name = "1ȣ��";

	// �߻�Ŭ������ ��������Ƿ� ���ǵ� �޼ҵ带 ��� �������̵� �ؾ� ������ ������� �ȴ�.
	@Override
	public void kimchi() {
		System.out.println("��ġ � : 4,500�� �Դϴ�.");
	}
	
	@Override
	public void bude() {
		System.out.println("�δ� � : 5,000�� �Դϴ�.");
	}
	
	@Override
	public void sunde() {
		System.out.println("���뱹 : ������� �ʽ��ϴ�.");
	}

	@Override
	public void bibim() {
		System.out.println("����� : 6,000�� �Դϴ�.");
	}

	@Override
	public void gonggibob() {
		System.out.println("����� : 1,000�� �Դϴ�.");
	}
	
	public String getName() {
		return name;
	}
	
}
