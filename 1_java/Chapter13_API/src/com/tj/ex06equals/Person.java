package com.tj.ex06equals;

// �̸� �ֹι�ȣ
public class Person {
	private String juminNo;
	private String name;

	public Person() {
	}

	public Person(String juminNo, String name) {
		this.juminNo = juminNo;
		this.name = name;
	}

	@Override // object.equals() ������
	public boolean equals(Object obj) {
		// boolean resulte = false;
		// p1.equals(p2) -> p1 �� this �� p2 �� obj
		// if(this == obj) { resulte = true; }
		// else obj �� Person ������ Ȯ���� obj�� Person������ ����ȯ��
		// return this.�ֹι�ȣ == obj.�ֹι�ȣ
		/*
		 * if(this == obj) { resulte = true; } else
		 */
		// this.juminNo �� ((Person)obj).juminNo ������ �ٸ����� return

		if (obj != null && obj instanceof Person) { // obj �� ���� �ְ� Person ������ Ȯ�� (true) 
			// j = �ֹ� ��ȣ �´���
			boolean jumin = juminNo.equals(((Person) obj).juminNo);
			// n = �̸��� �´��� 
			boolean na = name.equals(((Person)obj).name);
			
			return jumin && na;	
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "[�ֹι�ȣ] : " + juminNo + "\t[�̸�] : " + name;
	}

}
