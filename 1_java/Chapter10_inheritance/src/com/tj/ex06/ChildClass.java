package com.tj.ex06;

public class ChildClass extends ParentClass {

	private String cStr = "아들 클래스";

	public ChildClass() {
		System.out.println("자식 생성자");
	}

	@Override
	public void getMamaName() {
		System.out.println("이쁜 우리 ");
		super.getMamaName(); // 상속 받은 부모의 함수를 호출한다.
	}

	// getter setter
	public String getcStr() {
		return cStr;
	}

	public void setcStr(String cStr) {
		this.cStr = cStr;
	}

}
