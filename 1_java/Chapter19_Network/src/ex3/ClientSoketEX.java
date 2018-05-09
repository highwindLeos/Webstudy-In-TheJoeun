package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSoketEX {
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader keybord;
	private BufferedReader reader;
	
	public ClientSoketEX() {
		// ���� ��ü (ip, port) �����, ��Ʈ���� �����ؼ� write �Ѵ�.
		try {
			socket = new Socket("127.0.0.1", 9000);
			keybord = new BufferedReader(new InputStreamReader(System.in)); // Ű���� �Է� ������ ���پ� �Է��Ҽ� �ִ�.
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 
			writer = new PrintWriter(socket.getOutputStream(), true); // 1����Ʈ �� �����͸� �Է��ؼ� ����.
			
			while (true) {// �޼����� ����ؼ� �������ش�.
				System.out.print("������ �޼���? >");
				String clientMsg = keybord.readLine(); 
				writer.println(clientMsg);
				System.out.println("client message : " + clientMsg);
				if (clientMsg.equals("bye")) { break; } // bye �� �Է��ϸ� �޼��� ���� ����
				System.out.println("���������� ���� �°� : "+ reader.readLine());
			}

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null) { writer.close(); }
				if (socket != null) { socket.close(); }
			} catch (Exception e) {	}
		} //finally catch
	}
}
