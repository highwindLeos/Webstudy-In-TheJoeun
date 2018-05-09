package com.tj.ex3file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex3File {

	public static void main(String[] args) throws IOException {
		File file = new File("files/inTest.txt");
		if (file.exists()) {
			// �����ϴ� �����̸� ������ ǥ�ذ�� ������ ����ũ�� ���ϼӼ�
			System.out.println("������ : " + file.getAbsolutePath()); // ���� ��θ� ��ȯ.
			System.out.println("����� : " + file.getCanonicalPath()); // ����θ� ��ȯ.
			Date time = new Date(file.lastModified()); // ������ ���������� ������ �ð��� ��ȯ.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (E) a hh�� mm�� ss��");

			System.out.println("������ : " + sdf.format(time));
			// ù��° �������� ��� �ɼ��� �����Ѵ�( %1$ )
			System.out.printf("%1$tY�� %1$tm�� %1$td�� (%1$ta) %1$tp %1$tH�� %1$tM�� %1$tS�� ", time);

			System.out.println("������ ũ�� : " + file.length());
			System.out.println("�б� �Ӽ� : " + file.canRead());
			System.out.println("���� �Ӽ� : " + file.canWrite());
			System.out.println("���� �Ӽ� : " + file.isHidden());

		} else {
			System.out.println("�������� �ʴ� �����Դϴ�.");
		}
	}

}
