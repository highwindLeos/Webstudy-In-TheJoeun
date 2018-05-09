package ex4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SenderThread extends Thread {
	
	private Socket socket;
	private PrintWriter writer;
	private Scanner sc;
	private String msg;
	
	public SenderThread(Socket socket) {
		this.socket = socket;
	} // �����ڿ��� ������ �ʱ�ȭ
	
	@Override
	public void run() {
		// 1 ��� ��Ʈ���� �����. 2 Ű����� ���� ���� msg �ް�. 3 println �Ѵ�.
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			sc = new Scanner(System.in);
			
			while (true) {
				msg = sc.nextLine();
				writer.println(msg);
				writer.flush();
				if (msg.equals("bye")) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {	}
		} // try catch
	}
}
