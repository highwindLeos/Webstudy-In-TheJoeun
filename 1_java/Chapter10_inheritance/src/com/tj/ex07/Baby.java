package com.tj.ex07;

public class Baby extends Person {

	public void cry() {
		System.out.println("�����");
	}

	@Override
	public void intro() {
		System.out.println(getName() + "�� �Ʊ�� �� ����");
		System.out.println("������ " + getCharacter());
	}

}
