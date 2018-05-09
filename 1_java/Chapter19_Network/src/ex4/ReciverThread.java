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
	} // 생성자에서 소켓을 생성해서 넣는다.
	
	@Override
	public void run() {
		// 1 입력 스트림을 만들고 2 readLine 3 콘솔에 출력
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				msg = reader.readLine();
				if(msg == null) { break; }
				System.out.println(socket.getInetAddress() + ">" + msg); // 받은 메세지를 뿌림
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
}
