package com.tj.ex07;

public class TestMain {

	public static void main(String[] args) {
		Person papa = new Person();
		
		papa.setName("�ƺ���");
		papa.setCharacter("�׶���");
		papa.intro();
		
		Person mam = new Person();
		
		mam.setName("������");
		mam.setCharacter("������");
		mam.intro();
		
		Baby child1 = new Baby();
		
		child1.setName("�Ʊ��");
		child1.setCharacter("�ʹ� �Ϳ���");
		child1.intro();
		child1.cry();
		
	}

}
