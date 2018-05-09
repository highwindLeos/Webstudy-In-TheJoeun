package com.tj.condition;

// 컴퓨터 가 난수 점수를 발생하여 "점수와 해당 학점"을 출력
public class SwitchEx03 {

	public static void main(String[] args) {
		// 0 <= Math.random() < 1;
		// 0 <= Math.random()*101 < 101;
		// 0 ~ 100 까지의 정수 난수 : (int)(Math.random()*101);\
		int score = (int) (Math.random() * 101);
		char grade = ' ';

		switch (score / 10) {
		case 10: case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		case 5:	case 4:	case 3:	case 2:	case 1:	case 0:
			grade = 'F';
			break;
		default: //아무것도 아닐때.
			grade = 'Z';
		}
		System.out.printf("점수는 : %d\n학점은 %c 학점입니다.",score ,grade);
	}

}
