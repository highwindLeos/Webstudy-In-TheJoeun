package com.tj.ex04Studentmanage;

import java.util.Scanner;

// ��� ��ȣ�� �ް� �ش� �й� �ް� ������ ���ϴ� ������ �޾� ����
public class StudentMain {

	public static void main(String[] args) {
		Student[] students = { new Student(2018001, "ȫ�浿", 20, "uiux"), new Student(2018002, "ȫ����", 21, "bigdata"),
				new Student(2018003, "�̽���", 34, "datasecurity"), new Student(2018004, "�̸�ȭ", 25, "movie"),
				new Student(2018005, "��Ǯ", 29, "animation") };

		Scanner sc = new Scanner(System.in);

		int fn; // ��ɹ�ȣ�� �޴� ����
		int hakbun; // �й��� �޴� ����
		String data;// ������ ������ ����
		int idx; // ������ Index

		/*
		 * for (Student stemp : students) { stemp.setAge(stemp.getAge()+1); // ���� ���̸� +1
		 * �� ���̸� setting ���ش�. } System.out.println();
		 */

		for (Student stemp : students) { // Ȯ�� for ��
			System.out.println(stemp.out());
		}
		System.out.println();

		while (true) { // ���� �ݺ�
			do {
				System.out.print("���ϴ� ��ɹ�ȣ (1: �̸�����, 2 : ���̺���, 3 : ��������, 0 : ����) ?");
				fn = sc.nextInt();
			} while (fn > 3 || fn < 0); // 3���� ũ�ų� 0���� ������ ��� ���

			if (fn == 0) {
				break; // while ���� ��������.
			}
			// �� �κ��� fn 1~3 ������ ���� ������ ����.
			System.out.println("������ �л��� �й��� �Է����ּ���.");
			hakbun = sc.nextInt(); // �й��� �Է¹���
			// students[0] ~ st[������] hakbun�̶� ���� �й��� �л��� index
			for (idx = 0; idx < students.length; idx++) {
				if (students[idx].getStudentNum() == hakbun) {
					break; // �ݺ����� ����������.
				}
			} // for
				// * : idx == students.length �� ������ �й��� ã�� ���� ��� : �й��߿� �Է��й��� ����.
				// else : idx != students.length �̸� idx �� �ٲ� �л��� �迭 index �� �ȴ�.
			if (idx == students.length) {
				System.out.println("�Է��Ͻ� �й��� �л��� �����ϴ�.");
			} else {
				System.out.print("������ �����͸� �Է����ּ���. ?");
				System.out.println("���� �� �л��� ������ : " + students[idx].out());
				data = sc.next();
				// ������ �ٲٱ� students[idx].modify(fn,data)
				students[idx].modify(fn, data); // ������ ����
				System.out.println("���� �� �л��� ������ " + students[idx].out());
			}
		} // while ���� �ݺ���.
		System.out.println("�ȳ��� ������. �л� �����ʹ� ������ �����ϴ�.");

		for (Student stemp : students) { // Ȯ�� for ��
			System.out.println(stemp.out());
		} // �����͸� ��� ����ϰ� ���α׷� ��.
	}
}
