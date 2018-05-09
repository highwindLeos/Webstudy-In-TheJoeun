package com.tj.ex11;

public class StudentMain {

	public static void main(String[] args) {
		Student[] st = { 
				new Student("���켺", 90, 80, 95), 
				new Student("���ϴ�", 100, 80, 95),
				new Student("Ȳ����", 95, 80, 90), 
				new Student("������", 95, 90, 99), 
				new Student("������", 95, 90, 90),
				new Student("��Ƹ�", 97, 88, 94), };

		int[] total = new int[4]; // 0 ~ 4

		line("��", 60);
		System.out.println("\t\t��\t��\tó\t��");
		line("��", 60);
		System.out.println("��ȣ\t �̸�\t ����\t ����\t ����\t ����\t ���");
		line("=", 60);

		for (Student s : st) {
			System.out.println(s.printOut()); // �Լ����� ����� �����ؼ� �����.
			total[0] += s.getKor();
			total[1] += s.getMath();
			total[2] += s.getEng();
			total[3] += s.getTotal();
		}

		line("��", 60);

		System.out.print("���� : \t\t ");
		for (int t : total) {
			System.out.print(t + "\t");
		}

		double num = total[3] / (double) ((total.length - 1) * st.length);
		String avgtotal = String.format("%.2f", num); // ������ ��ȯ.
		System.out.println(avgtotal); // ����� �� ���
	}

	private static void line(String string, int value) {
		for (int i = 0; i < value; i++) {
			System.out.print(string);
		}
		System.out.println();
	}

}
