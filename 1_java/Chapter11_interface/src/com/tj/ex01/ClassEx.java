package com.tj.ex01;
//Ŭ���� ����� ���� ��Ӹ� ���� ���� ����� �Ұ��ϴ�.
// �������̽� implements(����) �� ����, ���� ������ ��� �����ϴ�. 
// 
public class ClassEx implements InterfaceEx1, InterfaceEx2 {

	@Override
	public void ex1() {
		System.out.println("���� ������ Ŭ�������� ex1");
		System.out.println("ex1 ��� ��� : " + CONSTANT_NUM);
		System.out.println("ex2 ��� ��� : " + CONSTANT_STRING);
	}

	@Override
	public void ex2() {
		System.out.println("���� ������ Ŭ�������� ex2");
	}


}
