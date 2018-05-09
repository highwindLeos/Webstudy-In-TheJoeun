package com.tj.ex42bytestream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex6PrintWriter {

	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter out = null;

		ArrayList<Students> students = new ArrayList<Students>();

		students.add(new Students("ȫ�浿", 90, 100, 100));
		students.add(new Students("�̸�ȭ", 90, 70, 68));
		students.add(new Students("�̷���", 88, 99, 87));
		students.add(new Students("���굿", 67, 98, 99));
		students.add(new Students("������", 90, 95, 80));

		try {
			// os = new FileOutputStream("files/students.txt");
			// writer = new FileWriter("files/students.txt");
			// out = new PrintWriter("files/students.txt"); �⺻��Ʈ��ó�� ����ص� �ȴ�.
			// out = new PrintWriter(os); // ���� ��Ʈ��. 1����Ʈ 2����Ʈ ������� �ʴ´�.
			out = new PrintWriter("files/students.txt");

			for (Students st : students) {
				out.printf("%5s : %3d %3d %3d %5.1f\r \n", 
						st.getName(), st.getKor(), st.getEng(), st.getMat(), st.getAvg());
				
				System.out.printf("%5s : %3d %3d %3d %5.1f \n", 
						st.getName(), st.getKor(), st.getEng(), st.getMat(), st.getAvg()); // ���� ����� ���� ��¹�
			}
			System.out.println("----------------------------------");
			out.println("------------------------------------");
			System.out.println("���� �л�" + students.size()+ "�� ���");
			System.out.printf("%1$tm�� %1$td�� %1$tH�� %1$tM��", new GregorianCalendar()); 
			out.printf("%1$tm�� %1$td�� %1$tH�� %1$tM��", new Date());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
				out.close();
		}// try catch finally

	}// main

}// class
