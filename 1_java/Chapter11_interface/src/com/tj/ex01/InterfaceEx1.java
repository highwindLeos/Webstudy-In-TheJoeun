package com.tj.ex01;
/* interface�� ����� static final ����� �߻�޼ҵ常 ����.
 * static final Ű����� ��������.
 * abstract�� ��������
 * private �Ұ�. �Ϲ� ���� �޼ҵ� �Ұ���.
*/
public interface InterfaceEx1 {
	public /*static final*/ int CONSTANT_NUM = 100; //static final Ű����� ��������.
	
	// private int i; // �������̽����� �Ϲ� ������ ���� �Ұ�.
	
	public /*abstract*/ void ex1(); // abstract�� ��������
	
//	public void ex(); // �������̽��� ���ǵ� ��� �޼ҵ�� �߻� �޼ҵ��.
}
