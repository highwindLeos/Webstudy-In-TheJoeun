package com.tj.ex42bytestream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex5Write {

	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("files/inout.txt", true); // ���Ͽ� ������  �߰��Ѵ�. �⺻���� false�� ���.
			/*char[] arr = {'��','��','��','��','��'};
			for (char ta : arr) {
				System.out.print(ta);
			}*/
			String str = "�ȳ��ϼ���\r\n�ڹ�";
			writer.write(str);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				writer.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
