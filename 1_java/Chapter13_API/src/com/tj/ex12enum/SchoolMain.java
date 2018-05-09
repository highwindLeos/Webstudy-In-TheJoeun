package com.tj.ex12enum;

public class SchoolMain {

	public static void main(String[] args) {
		int schooltype = SchoolType.ELEMENTERY;

		switch (schooltype) {
		case 1:
			System.out.println("ELEMENTERY");break;
		case 2:
			System.out.println("MIDDLE");break;
		case 3:
			System.out.println("HIGHT");break;
		case 4:
			System.out.println("UNIVERSITY");break;
		default:
			System.out.println("유효하지 않은 학생");break;
		}
	}

}
