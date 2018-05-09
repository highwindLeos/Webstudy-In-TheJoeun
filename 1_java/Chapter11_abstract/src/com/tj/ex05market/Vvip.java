package com.tj.ex05market;

public class Vvip extends Customer {
	private String birth; // 기념일

	public Vvip(String name, String phoneNum) {
		super(name, phoneNum); // 부모요소의 매개변수 2개 값이 있는 생성자.
	}

	public Vvip(String name, String phoneNum, String birth) {// 3개 값이 있는 생성자.
		super(name, phoneNum); // 부모요소의 매개변수 2개 값이 있는 생성자.
		this.birth = birth;
	}

	public void sendMeassage() {
		System.out.println("VVIP " + getName() + " 회원님의 생일을 축하 합니다.");
		System.out.println("소중한 날 " + birth + " 이네요.");
	} // 기념일 출력 메소드

	@Override
	public String outString() {
		return super.outString()+ "\n기념일 : "+ birth;
	} // 기념일 까지 더해서 출력하는 함수를 부모함수를 덮어써서 만듬.
	
	// getter setter
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}
