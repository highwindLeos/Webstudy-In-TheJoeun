package com.tj.ex08constract;

public class Baby extends Person {
	
	public Baby(String name, String character) {
		super(name, character); // �θ� �����ڸ� ȣ���Ѵ�. �ش� �ڵ�� �׻� �ֻ�ܿ� ����ؾ���.
		super.intro(); //
		System.out.println("test");
//		setName(name);
//		setCharacter(character);
	}

	public void cry() {
		System.out.println("�����");
	}

	@Override
	public void intro() {
		System.out.println(getName() + "�� �Ʊ�� �� ����");
		System.out.println("������ " + getCharacter());
	}

}
