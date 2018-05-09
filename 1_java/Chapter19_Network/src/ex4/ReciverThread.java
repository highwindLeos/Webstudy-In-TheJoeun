package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReciverThread extends Thread {
	private Socket socket;
	private BufferedReader reader;
	private String msg;
	
	public ReciverThread(Socket socket) {
		this.socket = socket;
	} // �����ڿ��� ������ �����ؼ� �ִ´�.
	
	@Override
	public void run() {
		// 1 �Է� ��Ʈ���� ����� 2 readLine 3 �ֿܼ� ���
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				msg = reader.readLine();
				if(msg == null) { break; }
				System.out.println(socket.getInetAddress() + ">" + msg); // ���� �޼����� �Ѹ�
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
}
