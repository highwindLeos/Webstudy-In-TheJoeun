package com.tj.ex11person;

public class Main {

	public static void main(String[] args) {
		
		Person st1 = new Student("A01","������","JAVA��");
		Person st2 = new Student("A02","�̶̹�","JAVA��");
		Person sf1 = new Staff("A03","������","��� ������");
		Person sf2 = new Staff("A04","���ֽ�","������");
		Person ga1 = new Gangsa("A05","�̱浿","��ü����");
		
		Person[] p = {st1,st2,sf1,sf2,ga1}; // ��ü�� �迭�� �ø�
		
		for(Person ptemp : p) {
			ptemp.print();
		}
	}

}
