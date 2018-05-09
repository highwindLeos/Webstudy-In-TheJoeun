package com.tj.ex01store;

// 매장 2호 클래스
// 김치찌개-5,000 부대찌개-5,000 비빔밥-5,000 순대국-5,000  공기밥-무료
public class Store2 extends HeadQuarterStore{
	private String name = "2호점";

	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000원 입니다.");
	}
	
	@Override
	public void bibim() {
		System.out.println("비빔밥 : 5,000원 입니다.");
	}
	
	@Override
	public void gonggibob() {
		System.out.println("공기밥 : 무료입니다.");
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 5,000 입니다.");
	}

	@Override
	public void sunde() {
		System.out.println("순대국 : 5,000 입니다.");
	}
	
	public String getName() {
		return name;
	}
	
}
