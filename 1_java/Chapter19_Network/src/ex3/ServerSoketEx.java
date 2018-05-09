package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoketEx{
	
	private ServerSocket serverSocket; // ����
	private Socket socket; // ���� ����
	private BufferedReader reader; // ���پ� �����͸� �о�� ����
	private PrintWriter writer; // ���� �ȵ� ��츦 ����� ����.
	private String msg; // �޼����� ���� ����.
	
	public ServerSoketEx() {
		// ���� ������ ���ϵ�
		try {
			serverSocket = new ServerSocket(9000);// 9000 ��Ʈ�� ���������� ����.
			System.out.print("Ŭ���̾�Ʈ�� ����ϰ� �ֽ��ϴ�. : 9000 ��Ʈ");

			while(true) {
				socket = serverSocket.accept(); // ����ϷḦ ���. ���� �ݺ��ϸ� ��� ���� Ŭ���̾�Ʈ�� ����Ѵ�.
				System.out.println("��û�� ���Դ�.");
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
				// ���پ� �о�������ؼ�InputStreamReader() �ȿ� ���� ��Ʈ���� �����;� �Ѵ�.
				writer = new PrintWriter(socket.getOutputStream(), true);
				
				while((msg = reader.readLine())!= null) { // �޼����� �ִٸ� true
					System.out.println(socket.getInetAddress() + ">" + msg);
					writer.println(" �޾Ƹ� " + msg);
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
	} // ������
}
