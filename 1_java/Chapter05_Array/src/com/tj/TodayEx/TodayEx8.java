package com.tj.TodayEx;

public class TodayEx8 {

	private static void line(char ch, int no) {

		for (int i = 0; i < no; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}// line() 매개변수는 2개

	private static void line2(int no) {
		for (int i = 0; i < no; i++) {
			System.out.print("■");
		}
		System.out.println();
	}// line2()

	public static void main(String[] args) {
		String[] title = { "제품명", "1월", "2월", "3월", "4월", "합계", "평균" };
		String[] name = { "냉장고", "테레비", "청소기" };
		int[][] score = { { 250, 170, 300, 780 }, { 170, 120, 150, 220 }, { 450, 230, 400, 250 } };
		int sum = 0;
		double avg;
		int[] total = new int[4]; // 값으로 0으로 초기화됨.

		line('=', 60);
		System.out.println("\t매\t출\t현\t황");
		line('=', 60);

		for (String t : title) {
			System.out.print(t + "\t"); // 제목 줄을 출력
		}

		System.out.println();
		line2(60);

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

		line2(60);
		System.out.print("총계\t");
		for (int i = 0; i < total.length; i++) {
			System.out.print(total[i] + "\t");
			sum += total[i];
		} // for 총계
		avg = (double) sum / total.length; // 합계를 총점 인덱스 길이 만큼 나눈다.
		System.out.printf("%d\t%.1f\n", sum, avg);
		line2(60);
	}// main
}// class
