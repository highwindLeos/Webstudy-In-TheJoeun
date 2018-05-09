package com.tj.ex7;

public class StudentMain {

	public static void main(String[] args) {
		/*
		 * Student st1 = new Student("정우성", 99, 70, 75); Student st2 = new
		 * Student("김하늘", 80, 88, 90); Student st3 = new Student("황정민", 88, 90, 100);
		 * Student st4 = new Student("강동원", 100, 87, 85); Student st5 = new
		 * Student("유아인", 77, 87, 95);
		 */

		Student[] st = { new Student("이승훈", 99, 70, 75), 
						new Student("이데이", 80, 88, 90),
						new Student("이만화", 88, 90, 100), 
						new Student("이주리", 100, 87, 85), 
						new Student("강바다", 77, 87, 95) };
		
		int[] total = new int[4]; // 국어 영어 수학 총점을 각각 누적.

		line("■", 50);
		System.out.println("\t성\t적\t처\t리\t");
		line("■", 50);
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균");
		line("=", 50);

		/*
		 * for (int i = 0; i < st.length; i++) { st[i].show();
		 * 
		 * }
		 */

		for (Student s : st) {
			s.show();
			total[0] += s.getKor(); // 국어 총점 누적.
			total[1] += s.getMath(); // 수학 총점 누적.
			total[2] += s.getEng(); // 영어 총점 누적.
			total[3] += s.getSum(); // 총점의 합을 누적.
		}

		line("=", 50);

		System.out.print("총 점  \t");
		for (int t : total) {
			System.out.print(t + " \t");
		}
		System.out.println(total[3] / (double)((total.length - 1) * st.length)); // 평균의 총 평균

		// System.out.printf("총점\t %d\t %d\t %d\t %d\t \n", total[0], total[1], total[2], total[3],);

		line("■", 50);

	}

	private static void line(String string, int value) {
		for (int i = 0; i < value; i++) {
			System.out.print(string);
		}
		System.out.println();
	}

}
