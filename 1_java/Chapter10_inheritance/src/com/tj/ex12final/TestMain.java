package com.tj.ex12final;

public class TestMain {

	public static void main(String[] args) {
		
		Animal dog = new Dog(); // �θ��� ���� �״�� ���� �ִ�. �ڽĵ��� ��ü�� �θ��� ���� ���� �Ϸ��� ����.
		Animal rabbit = new Rabbit();
		Animal animal = new Animal();
		
		dog.running(); dog.running();
		dog.stop();
		
		rabbit.running(); rabbit.running();
		rabbit.stop();
		
		animal.running();
		animal.stop();
	}

}
