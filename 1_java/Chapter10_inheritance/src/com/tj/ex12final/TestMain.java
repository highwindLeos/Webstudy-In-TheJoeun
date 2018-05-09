package com.tj.ex12final;

public class TestMain {

	public static void main(String[] args) {
		
		Animal dog = new Dog(); // 부모의 형을 그대로 쓸수 있다. 자식들의 객체를 부모의 형과 같게 하려고 쓴다.
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
