package com.tj.ex06;

public class ParentClass {

	private String pStr = "�θ� Ŭ����";

	public ParentClass() {
		System.out.println("�θ� ������");
	}

	// getter setter
	public void getPapaName() {
		System.out.println("�ƺ� ȫ�浿");
	}

	public void getMamaName() {
		System.out.println("���� �����");
	}

	public String getpStr() {
		return pStr;
	}

	public void setpStr(String pStr) {
		this.pStr = pStr;
	}

}
