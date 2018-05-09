package com.tj.ex2ioclass;

import java.io.*;
import java.util.*;
// do while ���� �̿��Ͽ� id ip time �� �޾� ������ ���Ϸ� ���.
// ������ ������ ������ arrayList �� �Է¹޾� �ֿܼ� ���
public class LogMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		OutputStream os = null;
		DataOutputStream dos = null;
		
		String id, ip; int time;
		String fn; // ��� ���� ����
		
		File file = new File(
		"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/data.txt");
		
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			os = new FileOutputStream(file,true); // ������ ������ �߰��Ѵ�. ����� ����. �⺻�� false
			dos = new DataOutputStream(os);
			do {
				System.out.println("�����ڰ� �� �ֳ���(Y/N)");
				fn = sc.next();
				if(fn.equalsIgnoreCase("n")) {
					break; // �ݺ��� Ż��
				}else if (fn.equalsIgnoreCase("y")) { //��ҹ��ڸ� �������� �ʰ� �Էµ� ���ڸ� ���ؼ� ������ �����Ѵ�.
					System.out.print("id��?");
					dos.writeUTF(sc.next());
					System.out.print("ip��?");
					dos.writeUTF(sc.next());
					System.out.print("���ӽð��� (0~24��)?");
					dos.writeInt(sc.nextInt());
				}
			}while(true);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) { dos.close(); }
				if (os != null) { os.close(); }
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // ���� ��� try-catch-finally 
		
	}

}
