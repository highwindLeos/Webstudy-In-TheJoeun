package com.tj.ex06;

public class ChildClass extends ParentClass {

	private String cStr = "�Ƶ� Ŭ����";

	public ChildClass() {
		System.out.println("�ڽ� ������");
	}

	@Override
	public void getMamaName() {
		System.out.println("�̻� �츮 ");
		super.getMamaName(); // ��� ���� �θ��� �Լ��� ȣ���Ѵ�.
	}

	// getter setter
	public String getcStr() {
		return cStr;
	}

	public void setcStr(String cStr) {
		this.cStr = cStr;
	}

}
