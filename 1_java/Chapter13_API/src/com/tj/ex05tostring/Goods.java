package com.tj.ex05tostring;

//������ : �ڵ�(gCode), �̸�(gName), ������(stock), ����(price)
// new Goods("a001","�����",10,1200);
// sell("a001","0703","2") // ���ű�� : ��ǰ�ڵ� , ȸ������ó, ���ż���
public class Goods {

	private String gCord;
	private String gName;
	private int stock;
	private int price;

	public Goods(String gCord, String gName, int stock, int price) {
		this.gCord = gCord;
		this.gName = gName;
		this.stock = stock;
		this.price = price;
	} // ��ǰ�� �����Ҷ� ��� �����͸� �ʱ�ȭ (4��)

	@Override
	public String toString() { // �����(a01) 1200�� ��� 1�� ���� �������� ��ȯ
		String resulte;
		resulte = gName + "(" + gCord + ")" + price + "�� ���" + stock + "��";

		return resulte;
	}

}
