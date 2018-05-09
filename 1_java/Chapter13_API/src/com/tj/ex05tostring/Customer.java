package com.tj.ex05tostring;
//연락처(tel), 이름(cName), 누적구매금액(money), 포인트(point), 기념일(birth”10-10”), 
//고객분류(vip=true또는 false)

public class Customer {
	private String tel; // 010-0000-0000
	private String cName; // 이름
	private int money; // 누적구매금액
	private int point; // 회원포인트
	private String birth; // 기념일
	private Boolean vip; // VIP 고객 여부 : flase 일반 / true VIP
	
	public Customer(String tel, String cName, String birth) {
		this.tel = tel;
		this.cName = cName;
		this.birth = birth;
		money = 0; vip = false; 
		point = 1000;
	} // 데이터 3개만 초기화 한다.
	
	public Customer(String tel, String cName) {
		this.tel = tel;
		this.cName = cName;
		money = 0; vip = false; 
		point = 1000;
	} // 데이터 2개만 초기화 한다.
	
	// 메소드.
	@Override
	public String toString() {
		String resulte;
		resulte = "[연락처] : " + tel + "[이름] : " + cName + "[누적구매금액] : "+ money;
		resulte += "[포인트] : " + point;
		resulte += (vip == true) ? "VIP 등급 고객입니다." : "일반등급 고객입니다.";
		
		return resulte;
	}
	
}
