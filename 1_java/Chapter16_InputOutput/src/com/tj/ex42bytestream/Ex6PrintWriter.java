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

		students.add(new Students("홍길동", 90, 100, 100));
		students.add(new Students("이만화", 90, 70, 68));
		students.add(new Students("이레오", 88, 99, 87));
		students.add(new Students("마산동", 67, 98, 99));
		students.add(new Students("이종로", 90, 95, 80));

		try {
			// os = new FileOutputStream("files/students.txt");
			// writer = new FileWriter("files/students.txt");
			// out = new PrintWriter("files/students.txt"); 기본스트림처럼 사용해도 된다.
			// out = new PrintWriter(os); // 보조 스트림. 1바이트 2바이트 상관하지 않는다.
			out = new PrintWriter("files/students.txt");

			for (Students st : students) {
				out.printf("%5s : %3d %3d %3d %5.1f\r \n", 
						st.getName(), st.getKor(), st.getEng(), st.getMat(), st.getAvg());
				
				System.out.printf("%5s : %3d %3d %3d %5.1f \n", 
						st.getName(), st.getKor(), st.getEng(), st.getMat(), st.getAvg()); // 위의 포멧과 같은 출력문
			}
			System.out.println("----------------------------------");
			out.println("------------------------------------");
			System.out.println("이하 학생" + students.size()+ "명 출력");
			System.out.printf("%1$tm월 %1$td일 %1$tH시 %1$tM분", new GregorianCalendar()); 
			out.printf("%1$tm월 %1$td일 %1$tH시 %1$tM분", new Date());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
				out.close();
		}// try catch finally

	}// main

}// class
