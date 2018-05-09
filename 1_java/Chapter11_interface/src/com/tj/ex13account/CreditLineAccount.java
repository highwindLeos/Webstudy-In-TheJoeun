package com.tj.ex13account;
//new Account(“111-1111”, ”박길동”, [1000,]”1234-1234-1234-1234”, 2200000000L);

public class CreditLineAccount extends CheakingAccount {
	private long creditLine; //신용카드 한도

	// 생성자
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	} // 매개변수 4개 생성자.

	public CreditLineAccount(String accountNo, String ownerName, 
							 int balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	} // 매개변수 5개 생성자.
	
	@Override
	public int pay(String cardNo, int amount) {
		int resulte = 0;
		//카드번호 맞으면 한도 조회 해서 결제 한다.
		if(getCardNo().equals(cardNo)) {
			if(creditLine >= amount) { //적어도 예금이 한도보다 적거나 같아여ㅑ한다,
				creditLine -= amount; // 한도 조정
				System.out.println(getOwnerName()+"님 " + amount + "원 결제 하여 한도 "+ creditLine +"원 남음");
			} else {
				System.out.println("한도 초과 하여 결제 불가");
			}
		}else {
			System.out.println("카드번호가 틀려 결제 불가");
		}
		
		return resulte;
	}
	
	
	

}
