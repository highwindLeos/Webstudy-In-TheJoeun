package com.tj.var;

public class Ex04avg {

	public static void main(String[] args) {
		
		int kor = 99;
		int math = 99;
		int eng = 98;
		int total = kor + math + eng;
		float avgf = (kor + math + eng) / 3.0f; //������ �Ǽ��� ����ؼ� ����� �Ǽ��� ������ش�.
		double avgd = (kor + math + eng) / 3.0; //������ �Ǽ��� ����ؼ� ����� �Ǽ��� ������ش�.
		
		System.out.println("������ " + total +"\t ����� " + avgf);
		System.out.println("������ " + total +"\t ����� " + avgd);

	}

}
