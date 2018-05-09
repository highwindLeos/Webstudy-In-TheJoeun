package ex1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
// 도메인 이름을 받아서 도메인 호스트 ip 주소와 내 시스템의 정보를 출력
public class Ex1InetAddress {
	private Scanner sc;
	private String domainname;
	private InetAddress inetAddress;
	
	public Ex1InetAddress() {
		sc = new Scanner(System.in);
		System.out.println("도메인 네임은? (ex : www.naver.com)");
		domainname = sc.next();
		
		try {
			inetAddress = InetAddress.getByName(domainname);
			
			System.out.println("HOST 네임 : " + inetAddress.getHostAddress());
			System.out.println("HOST IP 주소 : " + inetAddress.getHostAddress());
			System.out.println("LOCAL Name : " + InetAddress.getLoopbackAddress());
			System.out.println("LOCAL IP 주소 : " + InetAddress.getLocalHost()); // static 메소드

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage() + "알려지지 않은 호스트네임");
		}
	}
	
	public static void main(String[] args) {
		new Ex1InetAddress();
	}
	
}
