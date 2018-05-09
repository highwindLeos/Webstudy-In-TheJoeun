package com.tj.ex12final;

public class Dog extends Animal {
	
	@Override
	public void running() { // stop 을 final 을 지워야 오버라이딩됨.
		speed += 10;
		System.out.println("뛰면서 꼬리를 흔들어요. 현제 속도 : "+speed);
	}
	
	
}
