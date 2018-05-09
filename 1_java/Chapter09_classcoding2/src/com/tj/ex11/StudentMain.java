package com.tj.ex11;

public class StudentMain {

	public static void main(String[] args) {
		Student[] st = { 
				new Student("정우성", 90, 80, 95), 
				new Student("김하늘", 100, 80, 95),
				new Student("황정민", 95, 80, 90), 
				new Student("강동원", 95, 90, 99), 
				new Student("유아인", 95, 90, 90),
				new Student("김아름", 97, 88, 94), };

		int[] total = new int[4]; // 0 ~ 4

		line("■", 60);
		System.out.println("\t\t성\t적\t처\t리");
		line("■", 60);
		System.out.println("번호\t 이름\t 국어\t 수학\t 영어\t 총점\t 평균");
		line("=", 60);

		for (Student s : st) {
			System.out.println(s.printOut()); // 함수에서 결과를 리턴해서 출력함.
			total[0] += s.getKor();
			total[1] += s.getMath();
			total[2] += s.getEng();
			total[3] += s.getTotal();
		}

		line("■", 60);

		System.out.print("총점 : \t\t ");
		for (int t : total) {
			System.out.print(t + "\t");
		}

		double num = total[3] / (double) ((total.length - 1) * st.length);
		String avgtotal = String.format("%.2f", num); // 포멧을 변환.
		System.out.println(avgtotal); // 평균의 총 평균
	}

	private static void line(String string, int value) {
		for (int i = 0; i < value; i++) {
			System.out.print(string);
		}
		System.out.println();
	}

}
