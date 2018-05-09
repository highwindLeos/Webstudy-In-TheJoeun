package ex4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.omg.CORBA.portable.UnknownException;

public class ClientSoketMain {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			
			Thread reciver = new ReciverThread(socket);
			Thread sender = new SenderThread(socket);
			
			reciver.start();
			sender.start();
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			
		}
	}

}
