package com.tj.ex05tostring;
//����ó(tel), �̸�(cName), �������űݾ�(money), ����Ʈ(point), �����(birth��10-10��), 
//���з�(vip=true�Ǵ� false)

public class Customer {
	private String tel; // 010-0000-0000
	private String cName; // �̸�
	private int money; // �������űݾ�
	private int point; // ȸ������Ʈ
	private String birth; // �����
	private Boolean vip; // VIP �� ���� : flase �Ϲ� / true VIP
	
	public Customer(String tel, String cName, String birth) {
		this.tel = tel;
		this.cName = cName;
		this.birth = birth;
		money = 0; vip = false; 
		point = 1000;
	} // ������ 3���� �ʱ�ȭ �Ѵ�.
	
	public Customer(String tel, String cName) {
		this.tel = tel;
		this.cName = cName;
		money = 0; vip = false; 
		point = 1000;
	} // ������ 2���� �ʱ�ȭ �Ѵ�.
	
	// �޼ҵ�.
	@Override
	public String toString() {
		String resulte;
		resulte = "[����ó] : " + tel + "[�̸�] : " + cName + "[�������űݾ�] : "+ money;
		resulte += "[����Ʈ] : " + point;
		resulte += (vip == true) ? "VIP ��� ���Դϴ�." : "�Ϲݵ�� ���Դϴ�.";
		
		return resulte;
	}
	
}
