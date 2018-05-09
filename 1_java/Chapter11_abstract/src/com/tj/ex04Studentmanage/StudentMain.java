package com.tj.ex04Studentmanage;

import java.util.Scanner;

// 기능 번호를 받고 해당 학번 받고 수정을 원하는 데이터 받아 수정
public class StudentMain {

	public static void main(String[] args) {
		Student[] students = { new Student(2018001, "홍길동", 20, "uiux"), new Student(2018002, "홍구동", 21, "bigdata"),
				new Student(2018003, "이승훈", 34, "datasecurity"), new Student(2018004, "이만화", 25, "movie"),
				new Student(2018005, "강풀", 29, "animation") };

		Scanner sc = new Scanner(System.in);

		int fn; // 기능번호를 받는 변수
		int hakbun; // 학번을 받는 변수
		String data;// 변경할 데이터 변수
		int idx; // 수정할 Index

		/*
		 * for (Student stemp : students) { stemp.setAge(stemp.getAge()+1); // 기존 나이를 +1
		 * 로 나이를 setting 해준다. } System.out.println();
		 */

		for (Student stemp : students) { // 확장 for 문
			System.out.println(stemp.out());
		}
		System.out.println();

		while (true) { // 무한 반복
			do {
				System.out.print("원하는 기능번호 (1: 이름변경, 2 : 나이변경, 3 : 전공변경, 0 : 종료) ?");
				fn = sc.nextInt();
			} while (fn > 3 || fn < 0); // 3보다 크거나 0보다 작으면 계속 물어봄

			if (fn == 0) {
				break; // while 문을 빠져나감.
			}
			// 이 부분은 fn 1~3 사이의 값을 가지고 있음.
			System.out.println("수정할 학생의 학번을 입력해주세요.");
			hakbun = sc.nextInt(); // 학번을 입력받음
			// students[0] ~ st[끝까지] hakbun이랑 같은 학번인 학생의 index
			for (idx = 0; idx < students.length; idx++) {
				if (students[idx].getStudentNum() == hakbun) {
					break; // 반복문을 빠져나간다.
				}
			} // for
				// * : idx == students.length 의 조건은 학번을 찾지 못한 경우 : 학번중에 입력학번이 없음.
				// else : idx != students.length 이면 idx 는 바꿀 학생의 배열 index 가 된다.
			if (idx == students.length) {
				System.out.println("입력하신 학번의 학생은 없습니다.");
			} else {
				System.out.print("수정할 데이터를 입력해주세요. ?");
				System.out.println("변경 전 학생의 데이터 : " + students[idx].out());
				data = sc.next();
				// 데이터 바꾸기 students[idx].modify(fn,data)
				students[idx].modify(fn, data); // 데이터 변경
				System.out.println("변경 후 학생의 데이터 " + students[idx].out());
			}
		} // while 무한 반복문.
		System.out.println("안녕히 가세요. 학생 데이터는 다음과 같습니다.");

		for (Student stemp : students) { // 확장 for 문
			System.out.println(stemp.out());
		} // 데이터를 모두 출력하고 프로그램 끝.
	}
}
