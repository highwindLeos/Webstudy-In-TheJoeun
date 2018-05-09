package com.tj.var;

public class Ex04avg {

	public static void main(String[] args) {
		
		int kor = 99;
		int math = 99;
		int eng = 98;
		int total = kor + math + eng;
		float avgf = (kor + math + eng) / 3.0f; //정수와 실수를 계산해서 결과를 실수로 만들어준다.
		double avgd = (kor + math + eng) / 3.0; //정수와 실수를 계산해서 결과를 실수로 만들어준다.
		
		System.out.println("총점은 " + total +"\t 평균은 " + avgf);
		System.out.println("총점은 " + total +"\t 평균은 " + avgd);

	}

}
