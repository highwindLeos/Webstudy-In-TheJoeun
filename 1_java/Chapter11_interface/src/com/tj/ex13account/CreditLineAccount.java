package com.tj.ex13account;
//new Account(��111-1111��, ���ڱ浿��, [1000,]��1234-1234-1234-1234��, 2200000000L);

public class CreditLineAccount extends CheakingAccount {
	private long creditLine; //�ſ�ī�� �ѵ�

	// ������
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	} // �Ű����� 4�� ������.

	public CreditLineAccount(String accountNo, String ownerName, 
							 int balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	} // �Ű����� 5�� ������.
	
	@Override
	public int pay(String cardNo, int amount) {
		int resulte = 0;
		//ī���ȣ ������ �ѵ� ��ȸ �ؼ� ���� �Ѵ�.
		if(getCardNo().equals(cardNo)) {
			if(creditLine >= amount) { //��� ������ �ѵ����� ���ų� ���ƿ����Ѵ�,
				creditLine -= amount; // �ѵ� ����
				System.out.println(getOwnerName()+"�� " + amount + "�� ���� �Ͽ� �ѵ� "+ creditLine +"�� ����");
			} else {
				System.out.println("�ѵ� �ʰ� �Ͽ� ���� �Ұ�");
			}
		}else {
			System.out.println("ī���ȣ�� Ʋ�� ���� �Ұ�");
		}
		
		return resulte;
	}
	
	
	

}
