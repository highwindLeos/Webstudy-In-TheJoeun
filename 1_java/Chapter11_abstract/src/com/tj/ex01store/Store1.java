package com.tj.ex01store;
// 매장 1호 클래스
// 김치찌개-4,500 부대찌개-5,000 비빔밥-6,000 순대국-안팔아 공기밥-1,000원
public class Store1 extends HeadQuarterStore{
	private String name = "1호점";

	// 추상클래스를 상속했으므로 정의된 메소드를 모두 오버라이드 해야 오류가 사라지게 된다.
	@Override
	public void kimchi() {
		System.out.println("김치 찌개 : 4,500원 입니다.");
	}
	
	@Override
	public void bude() {
		System.out.println("부대 찌개 : 5,000원 입니다.");
	}
	
	@Override
	public void sunde() {
		System.out.println("순대국 : 취급하지 않습니다.");
	}

	@Override
	public void bibim() {
		System.out.println("비빔밥 : 6,000원 입니다.");
	}

	@Override
	public void gonggibob() {
		System.out.println("공기밥 : 1,000원 입니다.");
	}
	
	public String getName() {
		return name;
	}
	
}
