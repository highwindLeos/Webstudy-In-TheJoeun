package com.tj.ex10wrapper;

public class WrapperEx2 {
	public static void main(String[] args) {
		String score = "90";

		int intscore = Integer.parseInt(score); // ���ڷ� ���� ���ڸ� int ������ �ٲپ� ������ �־��ش�. �ڡڡ�
		byte byteScore = Byte.parseByte("90"); // ���ڷ� ���� ���ڸ� byte ������ �ٲپ� ������ �־��ش�.
		long longscore = Long.parseLong("90"); // ���ڷ� ���� ���ڸ� long ������ �ٲپ� ������ �־��ش�.

		System.out.println("�� : " + (intscore + byteScore + longscore));

		String str = "" + 90; // ���ڰ� ���ڿ��� ���Ѵ�. "90"
		str = String.valueOf(90); // ���ڰ� ���ڿ��� ���Ѵ�. "90" ��

	}
}
