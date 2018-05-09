package ex2conn_string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

// URL주소를 입력받음 http://www.google.com -> URL 객체 -> connection -> Inputstream -> 입력
// -> 입력받은 네트워크로 부터 입력받은 값을 파일 출력.
public class ExURLConStream {
	public static void main(String[] args) {
		// 키보드 입력
		BufferedReader webDataStream = null; // 웹에서 읽어오는 스트림
		File file = null; // 파일객체
		FileWriter fileWriter = null; // 파일쓰는 객체
		try {
			BufferedReader keybord = 
					new BufferedReader(new InputStreamReader(System.in));
			System.out.print("프로토콜을 포함한 주소는 ?");
			String address = keybord.readLine();
			
			URL url = new URL(address); // 주소값을 매개로 url 객체 생성.
			// URL 객체 정보.
			System.out.println("prototal : " + url.getProtocol());
			System.out.println("port number : " + url.getPort());
			System.out.println("HostName : " + url.getHost());
			System.out.println("URL 객체내용 : " + url.getContent());
			System.out.println("URL 전채 : " + url.toExternalForm());
			
			// 네트워크입력스트림 만들기
			URLConnection conn = url.openConnection(); //연결 객체를 생성.
			webDataStream = 
					new BufferedReader(new InputStreamReader(conn.getInputStream())); // 1줄씩 가져오는 인풋으로 만들었다.

			//읽어오기
			file = new File("src/connection.html");
			fileWriter = new FileWriter(file);
			
			while(true) {
				String source = webDataStream.readLine(); // 한줄씩 읽어온다.
				if (source == null) break;
				fileWriter.write(source);
			}
			System.out.println("파일 쓰기 완료");
			
			//파일출력 스트림 만들기
			
			// read 한걸 파일 출력

			
		} catch (IOException e) {
			System.out.println(e.getMessage()+ "입력이 잘못되었습니다.");
		} finally {
			try {
				if (fileWriter != null) { fileWriter.close(); }
				if (webDataStream != null) { webDataStream.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}// try catch
		
	}

}
