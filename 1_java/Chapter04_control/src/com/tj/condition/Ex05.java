package com.tj.condition;

import java.util.Scanner;

/* 국 영 수 를 입력받아 평균을 구하고
 * 각과목이 평균보다 높은지 낮은지 출력.
*/

public class Ex05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요.");
		int kor = sc.nextInt();
		
		System.out.println("영어 점수를 입력하세요.");
		int eng = sc.nextInt();
		
		System.out.println("수학 점수를 입력하세요.");
		int math = sc.nextInt();
		
		double avg = (double)(kor + eng + math) / 3; // 평균을 구한다.
//		double avg = (kor + eng + math) / 3.0; // 실수로 계산하여 실수값이 대입된다.
		
//		System.out.println("평균은 " + avg);
		System.out.printf("평균은 %.2f \n", avg);
		
		// 국어
		if (kor > avg) {
			System.out.println("국어는 평균보다 " + (kor - avg) + "점 높다.");
		} else if(kor < avg){
			System.out.println("국어는 평균보다 " + (avg - kor) + "점 낮다.");
		} else {
			System.out.println("국어는 평균과 같다.");
		}
		// 영어
		if (eng > avg) {
			System.out.println("영어는 평균보다 " + (eng - avg) + "점 높다.");
		} else if(kor < avg){
			System.out.println("영어는 평균보다 " + (avg - eng) + "점 낮다.");
		} else {
			System.out.println("영어는 평균과 같다.");
		}
		// 수학
		if (math > avg) {
			System.out.println("수학은 평균보다 " + (kor - math) + "점 높다.");
		} else if(kor < avg){
			System.out.println("수학은 평균보다 " + (math - kor) + "점 낮다.");
		} else {
			System.out.println("수학은 평균과 같다.");
		}

		
	}

}
