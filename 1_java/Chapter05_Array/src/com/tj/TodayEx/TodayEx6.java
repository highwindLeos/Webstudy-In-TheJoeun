package com.tj.TodayEx;

public class TodayEx6 {

	private static void line(char ch, int no) {

		for (int i = 0; i < no; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}// line() 매개변수는 2개

	private static void line2() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}// line2()

	public static void main(String[] args) {
		String[] title = { "이름", "국어", "영어", "수학", "총점", "평균" };
		String[] name = { "정우성", "김하늘", "황정민", "강동원", "유아인" };
		int[][] score = { { 90, 90, 90 }, { 90, 95, 79 }, { 99, 98, 97 }, { 97, 93, 95 }, { 77, 63, 97 } };
		int sum = 0;
		double avg;
		int[] total = new int[3]; // 값으로 0으로 초기화됨.

		line('=', 50);
		System.out.println("\t성\t적\t표\t");
		line('=', 50);

		for (String t : title) {
			System.out.print(t + "\t"); // 제목 줄을 출력
		}

		System.out.println();
		line2();

		for (int i = 0; i < name.length; i++) { // 이름 배열의 길이.
			System.out.print(name[i] + "\t");
			for (int j = 0; j < score[i].length; j++) { // 점수 배열의 길이.
				// i행 j 열 점수를 출력하고 sum과 total[j] 에 누적
				System.out.print(score[i][j] + "\t"); // 점수 배열을 출력
				sum += score[i][j]; // 합계
				total[j] += score[i][j]; // 총점
			} // for-j
			avg = (double) sum / score[i].length;
			System.out.printf("%d \t %.1f\n", sum, avg);
			sum = 0;
		} // for-i
		
		line2();
		System.out.print("총계\t");
		for (int i = 0; i < total.length; i++) {
			System.out.print(total[i] + "\t");
			sum += total[i];
		} // for 총계
		avg = (double) sum / total.length;
		System.out.printf("%d\t%.1f\n", sum, avg);
		line2();
	}// main
}// class
