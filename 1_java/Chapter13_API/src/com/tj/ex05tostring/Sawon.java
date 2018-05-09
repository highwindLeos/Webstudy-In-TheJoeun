package com.tj.ex05tostring;

import java.text.SimpleDateFormat;

//������ : ���, �̸�, �μ�(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), �Ի���.
//������ : ���, �̸�, �μ�, �Ի����� ��ü���� ���Ϸ� �մϴ�
// �޼ҵ� : print() :[���]200121  [�̸�]ȫ�浿  [�μ�]COMPUTER  [�Ի���]2016��2��2��

import java.util.Date;
import java.util.TimeZone;

public class Sawon {
	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESING = "DESING";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";

	private String num; // ���
	private String name; // �̸�
	private String part; // �μ�
	private Date enterDate; // �Ի���

	// ������
	public Sawon() {}

	public Sawon(String num, String name, String part) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date();
	}

	// �޼ҵ�
//	public void print() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
//		System.out
//				.println("[���] : " + num + " [�̸�] : " + name + " [�μ�] : " + part + " [�Ի���] : " + sdf.format(enterDate));
//	} �̷� �ڵ�� ������� �ʱ�� �Ѵ�.

	public String toStr() {
		String resulte = "[���] : " + num + " [�̸�] : " + name + " [�μ�] : " + part;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		resulte += " [�Ի���] : " + sdf.format(enterDate);

		return resulte;
	} // ���� ��ȯ
	
	@Override
	public String toString() { // Object �� toString() �� ������.
		String resulte = "[���] : " + num + " [�̸�] : " + name + " [�μ�] : " + part;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		resulte += " [�Ի���] : " + sdf.format(enterDate);

		return resulte;
	}

	
}