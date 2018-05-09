package com.tj.ex7;

public class StudentMain {

	public static void main(String[] args) {
		/*
		 * Student st1 = new Student("���켺", 99, 70, 75); Student st2 = new
		 * Student("���ϴ�", 80, 88, 90); Student st3 = new Student("Ȳ����", 88, 90, 100);
		 * Student st4 = new Student("������", 100, 87, 85); Student st5 = new
		 * Student("������", 77, 87, 95);
		 */

		Student[] st = { new Student("�̽���", 99, 70, 75), 
						new Student("�̵���", 80, 88, 90),
						new Student("�̸�ȭ", 88, 90, 100), 
						new Student("���ָ�", 100, 87, 85), 
						new Student("���ٴ�", 77, 87, 95) };
		
		int[] total = new int[4]; // ���� ���� ���� ������ ���� ����.

		line("��", 50);
		System.out.println("\t��\t��\tó\t��\t");
		line("��", 50);
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		line("=", 50);

		/*
		 * for (int i = 0; i < st.length; i++) { st[i].show();
		 * 
		 * }
		 */

		for (Student s : st) {
			s.show();
			total[0] += s.getKor(); // ���� ���� ����.
			total[1] += s.getMath(); // ���� ���� ����.
			total[2] += s.getEng(); // ���� ���� ����.
			total[3] += s.getSum(); // ������ ���� ����.
		}

		line("=", 50);

		System.out.print("�� ��  \t");
		for (int t : total) {
			System.out.print(t + " \t");
		}
		System.out.println(total[3] / (double)((total.length - 1) * st.length)); // ����� �� ���

		// System.out.printf("����\t %d\t %d\t %d\t %d\t \n", total[0], total[1], total[2], total[3],);

		line("��", 50);

	}

	private static void line(String string, int value) {
		for (int i = 0; i < value; i++) {
			System.out.print(string);
		}
		System.out.println();
	}

}
