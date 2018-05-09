package ex4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoketMain {

	public static void main(String[] args) {

		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(9999);
			Socket socket = serverSocket.accept();
			System.out.println("����Ǿ����ϴ�.");
			System.out.println(socket.getInetAddress() + "�� �������.");
			
			Thread reciver = new ReciverThread(socket);
			Thread sender = new SenderThread(socket);
			
			reciver.start();
			sender.start();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
