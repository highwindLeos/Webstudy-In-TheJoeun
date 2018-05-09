package com.tj.ex02;

public class CModel implements IFunction {
	private String model = "C 모델";

	@Override
	public void dmbRecive() {
		System.out.println(model + "은 DMB 송수신 가능한 모델");
	}

	@Override
	public void lte() {
		System.out.println(model + "은 LTE 모델");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model + "은 TV 리모콘 미탑재 모델");
	}

}
