package com.tj.ex6preparedstatement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoInfoBLOBselect {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String sql = "SELECT * FROM PHOTOINFO WHERE ID = 'testID'";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		File downloadfile = new File("copyed.jpg");
		InputStream is = null;
		OutputStream os = null;	
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String id = rs.getString("id");
				Blob photo = rs.getBlob("photo");
				
				is = photo.getBinaryStream();
				os = new FileOutputStream(downloadfile);
				byte[] temp = new byte[5*1024];
				
				while (true) {
					int cnt = is.read(temp);
					if (cnt == -1) break; // 파일이 끝이라 while 문 탈출
					os.write(temp, 0, cnt);
				}
				
				System.out.println(" [다운 받은 파일명] : " + downloadfile.getName() + 
								   " [파일 용량] : " + downloadfile.length() + 
								   "byte");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) os.close();
				if (is != null) is.close();
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { System.out.println(e.getMessage());	}
		}
	}
}
