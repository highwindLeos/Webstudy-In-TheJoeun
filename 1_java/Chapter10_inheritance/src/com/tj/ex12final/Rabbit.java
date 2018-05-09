package com.tj.ex12final;

public class Rabbit extends Animal{
	
	@Override
	public void running() {
		speed += 30;
		System.out.println("겁나서 마구 뛰어요. 현제 속도 : " + speed);
	}

}
