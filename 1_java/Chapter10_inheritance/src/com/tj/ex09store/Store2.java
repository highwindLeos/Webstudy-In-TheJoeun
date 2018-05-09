package com.tj.ex09store;

// 매장 2호 클래스
public class Store2 extends HeadQuarterStore{
	
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
	
}
