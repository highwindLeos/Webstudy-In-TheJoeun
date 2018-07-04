package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.org.apache.bcel.internal.generic.FALOAD;
import com.tj.ex.dto.BoardDto;

public class BoardDao {
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public BoardDao () {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
	} // �����ڿ��� ConnectionPool �� �̿�
	

	// �۸�� ��� ArrayList<BoardDto> listBoard(startRow, endRow)
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
					"(SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP ASC) A) " + 
					"WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() ) {
				do {
					BoardDto dto = new BoardDto();
					
					dto.setbId(rs.getInt("bid"));
					dto.setbName(rs.getString("bname"));
					dto.setbTitle(rs.getString("btitle"));
					dto.setbContent(rs.getString("bcontent"));
					dto.setbHit(rs.getInt("bHit"));
					dto.setbDate(rs.getTimestamp("bdate"));
					dto.setbGroup(rs.getInt("bgroup"));
					dto.setbStep(rs.getInt("bstep"));
					dto.setbIndent(rs.getInt("bindent"));
					dto.setbIp(rs.getString("bip"));

					dtos.add(dto);
				} while(rs.next());
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return dtos;
	}
	
	// ��ü �� ������ ��ȯ�ϴ� �Լ� int getBoardCnt()
	public int getBoardCnt() {
		int totalCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("�� ���� ��ȯ ����");
				totalCnt = rs.getInt(1);
			} else {
				System.out.println("�� ���� ��ȯ ����");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return totalCnt;
	}
	
	//���۾��� int writeBoard(bName, bTitle, bContent, bIp)
	public int writeBoard(String bName, String bTitle, String bContent, String bIp) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 	   " VALUES ( MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(insertSql);		
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bIp);
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("�� ���� ����");
				result = SUCCESS;
			} else {
				System.out.println("�� ���� ����");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( pstmt != null || conn != null ) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}

	//���۾��� int writeBoard(dto)
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 	   " VALUES ( MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(insertSql);		
			
			pstmt.setString(1, dto.getbName());
			pstmt.setString(2, dto.getbTitle());
			pstmt.setString(3, dto.getbContent());
			pstmt.setString(4, dto.getbIp());
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("�� ���� ����");
				result = SUCCESS;
			} else {
				System.out.println("�� ���� ����");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( pstmt != null || conn != null ) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	
	// Ư���� ���� : BoardDto contentView(bId)
	public BoardDto contentView(int bId) {
		upHit(bId); // ��ȸ���� 1����
		
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setInt(1, bId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDto();
				
				dto.setbId(bId);
				dto.setbName(rs.getString("bname"));
				dto.setbTitle(rs.getString("btitle"));
				dto.setbContent(rs.getString("bcontent"));
				dto.setbDate(rs.getTimestamp("bdate"));
				dto.setbGroup(rs.getInt("bgroup"));
				dto.setbStep(rs.getInt("bstep"));
				dto.setbIndent(rs.getInt("bindent"));
				dto.setbIp(rs.getString("bip"));
				
				System.out.println("�� ���� ��ȯ ����");
			} else {
				System.out.println("�� ���� ��ȯ ����");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
	
		return dto;
	}
	
	private void upHit(int bId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "UPDATE MVC_BOARD SET BHIT = BHIT + 1 WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(insertSql);	
			
			pstmt.setInt(1, bId);
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("��ȸ�� ����");
			} else {
				System.out.println("��ȸ�� ����");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( pstmt != null || conn != null ) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
	}


	// Ư�� �ۼ��� (�ۼ��� ���� ����) int modifyBoard(bId, bName, bContent)
	public int modifyBoard(int bId, String bName, String bTitle, String bContent) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET BNAME = ?, " + 
					 "                     BTITLE = ?, " + 
					 "                     BCONTENT = ? " + 
					 "           WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, bId);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("�ۼ��� ����");
				result = SUCCESS;
			} else {
				System.out.println("�ۼ��� ����");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	public int modifyBoard(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET BNAME = ?, " + 
					 "                     BTITLE = ?, " + 
					 "                     BCONTENT = ? " + 
					 "           WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getbName());
			pstmt.setString(2, dto.getbTitle());
			pstmt.setString(3, dto.getbContent());
			pstmt.setInt(4, dto.getbId());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("�ۼ��� ����");
				result = SUCCESS;
			} else {
				System.out.println("�ۼ��� ����");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}

	// Ư�� �ۻ��� int deleteBoard(bId)
	public int deleteBoard(int bId) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MVC_BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bId);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("�ۻ��� ����");
				result = SUCCESS;
			} else {
				System.out.println("�ۻ��� ����");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	
	// �亯�۾����� A �۾� : void replayAstep(bGroupp, bStep)
	private void replayAstep(String bGroup, String bStep) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET  BSTEP = BSTEP + 1 " + 
					 " WHERE BGROUP = ? AND BSTEP > ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(bGroup));
			pstmt.setInt(2, Integer.parseInt(bStep));

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
	}
	// �亯�� �����ϱ��� ������ ������ �������� �Լ� BoardDto replyView(bid)
	public BoardDto replyView(int bId) {
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setInt(1, bId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDto();
				
				dto.setbId(rs.getInt("bid"));
				dto.setbName(rs.getString("bname"));
				dto.setbTitle(rs.getString("btitle"));
				dto.setbContent(rs.getString("bcontent"));
				dto.setbDate(rs.getTimestamp("bdate"));
				dto.setbGroup(rs.getInt("bgroup"));
				dto.setbStep(rs.getInt("bstep"));
				dto.setbIndent(rs.getInt("bindent"));
				dto.setbIp(rs.getString("bip"));
				
				System.out.println("�� ��ȯ ����");
			} else {
				System.out.println("�� ��ȯ ����");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
	
		return dto;		
	}
	
	// �亯�� ���� int reply(bGroup, bStep, bIndent, bName, bTitle, bContent , bIp)
		// �亯�� �ʿ��� ������ ���� :  bGroup, bStep, bIndent
		// ����� ������ : bName, bTitle, bContent , bIp
	public int reply(String bGroup, String bStep, String bIndent, String bName, String bTitle, String bContent , String bIp) {
		
		replayAstep(bGroup, bStep); // ����� ������ step �� indent ��ó��
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 " VALUES ( MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1); //�亯���� bStep : ������ bStep +1
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1); //�亯���� bIndent : ������ bIndent +1
			pstmt.setString(7, bIp);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("�亯�� ����");
				result = SUCCESS;
			} else {
				System.out.println("�亯�� ����");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	
}
