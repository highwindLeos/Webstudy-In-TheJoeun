package com.tj.ex02;

public class AModle implements IFunction {
	private String model = "A 모델";

	@Override
	public void dmbRecive() {
		System.out.println(model + "은 DMB 송수신 불가능한 모델");
	}

	@Override
	public void lte() {
		System.out.println(model + "은 3g 모델");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model + "은 TV 리모콘 미탑재 모델");
	}

}
