package ex1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
// ������ �̸��� �޾Ƽ� ������ ȣ��Ʈ ip �ּҿ� �� �ý����� ������ ���
public class Ex1InetAddress {
	private Scanner sc;
	private String domainname;
	private InetAddress inetAddress;
	
	public Ex1InetAddress() {
		sc = new Scanner(System.in);
		System.out.println("������ ������? (ex : www.naver.com)");
		domainname = sc.next();
		
		try {
			inetAddress = InetAddress.getByName(domainname);
			
			System.out.println("HOST ���� : " + inetAddress.getHostAddress());
			System.out.println("HOST IP �ּ� : " + inetAddress.getHostAddress());
			System.out.println("LOCAL Name : " + InetAddress.getLoopbackAddress());
			System.out.println("LOCAL IP �ּ� : " + InetAddress.getLocalHost()); // static �޼ҵ�

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage() + "�˷����� ���� ȣ��Ʈ����");
		}
	}
	
	public static void main(String[] args) {
		new Ex1InetAddress();
	}
	
}
