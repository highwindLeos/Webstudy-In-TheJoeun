package com.tj.ex1bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1. ������ ����.(��Ʈ�� ��ü ����) 2. Write �Ѵ�. 3. ������ �ݴ´�.(��Ʈ�� ��ü�� �����Ѵ�. close)
public class OutputStreamEx2 {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			// �ι�° ���ڰ����� true �� �ָ� '�߰�' ������� �۵��Ѵ�. ������ ����� �ʰ� ������ �߰��Ѵ�. �⺻�� false.
			os = new FileOutputStream( 
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/outTest.txt", true);
			String temp = "\n�ȳ��ϼ���\r\n�������"; // ���Ͽ� �� ���ڿ��� �����.
			byte[] bs = temp.getBytes(); // ���ڿ��� byte �� �ٲپ� �ݴϴ�.

//			for (int i = 0; i < bs.length; i++) {
//				os.write(bs[i]); // 1byte �� ���Ͽ� ����. �ѱ۵� �ڱⰡ �˾Ƽ� �Ѵ�
//			}
			
			os.write(bs); // �˾Ƽ� 1byte �� �Ἥ �۾��� �Ϸ��Ѵ�.

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "������ ����� �����ϴ�");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "������ �� �� �����ϴ�");
		} finally {
			// ������ �ݴ´�.
			try {
				if(os != null) { os.close(); } // FileOutputStream �� �ݴ´�.
			} catch (IOException e) {
				System.out.println(e.getMessage() + "���ٰ� ���� �߻�");
			}
			
		}
		System.out.println();
		System.out.println("���α׷� ����");
	}
}
