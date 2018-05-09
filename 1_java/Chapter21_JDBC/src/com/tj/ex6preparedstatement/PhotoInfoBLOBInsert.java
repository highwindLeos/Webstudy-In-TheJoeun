package com.tj.ex6preparedstatement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhotoInfoBLOBInsert {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String sql = "INSERT INTO PHOTOINFO VALUES ('testID', ?)";
		
		String filePath = "C:/image/program girl/java.jpg";
		File file = new File(filePath);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		InputStream is = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			pstmt = conn.prepareStatement(sql);
			is = new FileInputStream(file); // ��ǲ ��Ʈ�� ���� ��ü
			
			long fileLength = file.length();
			pstmt.setBlob(1, is, fileLength); // ���� �ʵ带 �����Ѵ�.
			int resulte = pstmt.executeUpdate();
			
			System.out.println(resulte > 0 ? "�Է� ����" : "�Է� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (is != null) is.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { System.out.println(e.getMessage());	}
		}
		
	}

}
