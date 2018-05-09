package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoketEx{
	
	private ServerSocket serverSocket; // 서버
	private Socket socket; // 연결 소켓
	private BufferedReader reader; // 한줄씩 데이터를 읽어올 변수
	private PrintWriter writer; // 연결 안될 경우를 대비한 변수.
	private String msg; // 메세지를 담을 변수.
	
	public ServerSoketEx() {
		// 서버 소켓이 할일들
		try {
			serverSocket = new ServerSocket(9000);// 9000 포트로 서버소켓을 연다.
			System.out.print("클라이언트를 대기하고 있습니다. : 9000 포트");

			while(true) {
				socket = serverSocket.accept(); // 연결완료를 대기. 무한 반복하면 계속 여러 클라이언트를 대기한다.
				System.out.println("요청이 들어왔다.");
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
				// 한줄씩 읽어오기위해선InputStreamReader() 안에 소켓 스트림을 가져와야 한다.
				writer = new PrintWriter(socket.getOutputStream(), true);
				
				while((msg = reader.readLine())!= null) { // 메세지가 있다면 true
					System.out.println(socket.getInetAddress() + ">" + msg);
					writer.println(" 메아리 " + msg);
				}
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer != null) { writer.close(); }
				if(reader != null) { reader.close(); }
				if(socket != null) { socket.close(); }
			}catch (Exception e2) {}
		} // try catch
	} // 생성자
}
