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
	} // 생성자에서 소켓을 초기화
	
	@Override
	public void run() {
		// 1 출력 스트림을 만든다. 2 키보드로 부터 보낼 msg 받고. 3 println 한다.
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
