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
		// 소켓 객체 (ip, port) 만들고, 스트림을 연결해서 write 한다.
		try {
			socket = new Socket("127.0.0.1", 9000);
			keybord = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력 정보를 한줄씩 입력할수 있다.
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 
			writer = new PrintWriter(socket.getOutputStream(), true); // 1바이트 씩 데이터를 입력해서 쓴다.
			
			while (true) {// 메세지를 계속해서 전달해준다.
				System.out.print("보내실 메세지? >");
				String clientMsg = keybord.readLine(); 
				writer.println(clientMsg);
				System.out.println("client message : " + clientMsg);
				if (clientMsg.equals("bye")) { break; } // bye 를 입력하면 메세지 전송 종료
				System.out.println("서버측에서 부터 온거 : "+ reader.readLine());
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
