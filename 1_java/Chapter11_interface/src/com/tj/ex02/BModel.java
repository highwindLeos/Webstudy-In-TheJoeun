package com.tj.ex02;

public class BModel implements IFunction {
	private String model = "B ��";

	@Override
	public void dmbRecive() {
		System.out.println(model + "�� DMB �ۼ��� ������ ��");
	}

	@Override
	public void lte() {
		System.out.println(model + "�� LTE ��");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model + "�� TV ������ ž�� ��");
	}

}
