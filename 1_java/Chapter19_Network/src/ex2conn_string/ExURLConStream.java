package ex2conn_string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

// URL�ּҸ� �Է¹��� http://www.google.com -> URL ��ü -> connection -> Inputstream -> �Է�
// -> �Է¹��� ��Ʈ��ũ�� ���� �Է¹��� ���� ���� ���.
public class ExURLConStream {
	public static void main(String[] args) {
		// Ű���� �Է�
		BufferedReader webDataStream = null; // ������ �о���� ��Ʈ��
		File file = null; // ���ϰ�ü
		FileWriter fileWriter = null; // ���Ͼ��� ��ü
		try {
			BufferedReader keybord = 
					new BufferedReader(new InputStreamReader(System.in));
			System.out.print("���������� ������ �ּҴ� ?");
			String address = keybord.readLine();
			
			URL url = new URL(address); // �ּҰ��� �Ű��� url ��ü ����.
			// URL ��ü ����.
			System.out.println("prototal : " + url.getProtocol());
			System.out.println("port number : " + url.getPort());
			System.out.println("HostName : " + url.getHost());
			System.out.println("URL ��ü���� : " + url.getContent());
			System.out.println("URL ��ä : " + url.toExternalForm());
			
			// ��Ʈ��ũ�Է½�Ʈ�� �����
			URLConnection conn = url.openConnection(); //���� ��ü�� ����.
			webDataStream = 
					new BufferedReader(new InputStreamReader(conn.getInputStream())); // 1�پ� �������� ��ǲ���� �������.

			//�о����
			file = new File("src/connection.html");
			fileWriter = new FileWriter(file);
			
			while(true) {
				String source = webDataStream.readLine(); // ���پ� �о�´�.
				if (source == null) break;
				fileWriter.write(source);
			}
			System.out.println("���� ���� �Ϸ�");
			
			//������� ��Ʈ�� �����
			
			// read �Ѱ� ���� ���

			
		} catch (IOException e) {
			System.out.println(e.getMessage()+ "�Է��� �߸��Ǿ����ϴ�.");
		} finally {
			try {
				if (fileWriter != null) { fileWriter.close(); }
				if (webDataStream != null) { webDataStream.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}// try catch
		
	}

}
