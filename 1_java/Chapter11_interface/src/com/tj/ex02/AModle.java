package com.tj.ex02;

public class AModle implements IFunction {
	private String model = "A ��";

	@Override
	public void dmbRecive() {
		System.out.println(model + "�� DMB �ۼ��� �Ұ����� ��");
	}

	@Override
	public void lte() {
		System.out.println(model + "�� 3g ��");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model + "�� TV ������ ��ž�� ��");
	}

}
