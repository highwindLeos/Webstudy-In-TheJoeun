package com.tj.ex08constract;

public class TestMain {

	public static void main(String[] args) {
		
		Person papa = new Person("�ƺ���","�׶���");
		papa.intro();
		
		Person mam = new Person("������","������");
		mam.intro();
		
		Baby child1 = new Baby("�Ʊ��","�ʹ� �Ϳ���");
		
		child1.intro();
		child1.cry();
		
	}

}
