package com.tj.condition;

// ��ǻ�� �� ���� ������ �߻��Ͽ� "������ �ش� ����"�� ���
public class SwitchEx03 {

	public static void main(String[] args) {
		// 0 <= Math.random() < 1;
		// 0 <= Math.random()*101 < 101;
		// 0 ~ 100 ������ ���� ���� : (int)(Math.random()*101);\
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
		default: //�ƹ��͵� �ƴҶ�.
			grade = 'Z';
		}
		System.out.printf("������ : %d\n������ %c �����Դϴ�.",score ,grade);
	}

}
