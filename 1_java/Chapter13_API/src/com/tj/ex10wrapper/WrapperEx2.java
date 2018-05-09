package com.tj.ex10wrapper;

public class WrapperEx2 {
	public static void main(String[] args) {
		String score = "90";

		int intscore = Integer.parseInt(score); // 문자로 들어온 숫자를 int 형으로 바꾸어 변수에 넣어준다. ★★★
		byte byteScore = Byte.parseByte("90"); // 문자로 들어온 숫자를 byte 형으로 바꾸어 변수에 넣어준다.
		long longscore = Long.parseLong("90"); // 문자로 들어온 숫자를 long 형으로 바꾸어 변수에 넣어준다.

		System.out.println("합 : " + (intscore + byteScore + longscore));

		String str = "" + 90; // 숫자가 문자열로 변한다. "90"
		str = String.valueOf(90); // 숫자가 문자열로 변한다. "90" ★

	}
}
