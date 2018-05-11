package com.tj.ex2homework2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tj.ex1homework1.Student;

public class SuperMarket extends JFrame implements ActionListener {
	
	// GUI variable
	private Container containPane;
	private JPanel jpup, jpbtn;
	private JScrollPane JScrollpane;
	private JTextArea jtxtPool;
	private JTextField jtxtTel, jtxtName, jtxtPoint, JtxtAmount;
	private Vector<String> items;
	private JComboBox<String> jcomLevel;
	private JButton jbtnTelSearch, jbtnNameSearch, jbtnPoint;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAlloutput,
					jbtnInsert, jbtnTelupdate, jbtnDelete, jbtnExit;
	
	// DB variavble
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ArrayList<Customer> customer;
	
	public SuperMarket() {
		customer = new ArrayList<Customer>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Window object
		containPane = getContentPane();
		containPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(5, 3));
		jpbtn = new JPanel(new FlowLayout());
		
		jtxtTel = new JTextField(10);
		jtxtName = new JTextField(10);
		jtxtPoint = new JTextField(10);
		JtxtAmount = new JTextField(10);
		// combo list
		items = new Vector<String>();
		items.add(""); // 0번 인덱스
		try {
			String combosql = "SELECT GRADE FROM CGRADE";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(combosql);
			
			while (rs.next()) {
				items.add(rs.getString("grade"));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "Driver");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL");
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			} catch (SQLException e) { System.out.println(e.getMessage());}
		}
		jcomLevel = new JComboBox<String>(items); // 콤보박스
		
		jbtnTelSearch = new JButton("폰 뒷 4자리 검색");
		jbtnNameSearch = new JButton("고객 이름 검색");
		jbtnPoint = new JButton("포인트로만  구매");
		
		jbtnBuy = new JButton("물품 구매");
		jbtnLevelOutput = new JButton("등급별 출력");
		jbtnAlloutput = new JButton("전체출력");
		jbtnInsert = new JButton("회원가입");
		jbtnTelupdate = new JButton("번호수정");
		jbtnDelete = new JButton("회원탈퇴");
		jbtnExit = new JButton("나가기");
		
		jpup.add(new JLabel("고객전화", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("고객이름", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("구매금액", (int) CENTER_ALIGNMENT));
		jpup.add(JtxtAmount);
		jpup.add(new JLabel("", (int) CENTER_ALIGNMENT));
		jpup.add(new JLabel("고객등급", (int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		
		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAlloutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelupdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		
		containPane.add(jpup);
		containPane.add(jpbtn);
		jtxtPool = new JTextArea(10, 50);
		JScrollpane = new JScrollPane(jtxtPool);
		containPane.add(JScrollpane);
		
		setSize(new Dimension(700, 450));
		setLocation(400, 300);
		setVisible(true);
		
		// 리스너
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAlloutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelupdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);
	}
	
	public SuperMarket(String title){
		this();
		setTitle(title);
	}
	
	public static void main(String[] args) {
		new SuperMarket("슈퍼마켓 프로그램");
	}
	
	private void ResetFilde() {
		jtxtTel.setText(""); // 초기화
		jtxtName.setText("");
		jtxtPoint.setText("");
		JtxtAmount.setText("");
		jcomLevel.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtnTelSearch) { // 연락처 검색 
			jtxtPool.setText(""); // 출력 필드초기화
			
			try {
				String selectSql1 = "SELECT C.*, G.GRADE, " +
								    "NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
								    "FROM CUSTOMER C, CGRADE G " + 
								    "WHERE C.GNO = G.GNO AND SUBSTR(CTEL, -4) = ?";
				
				String selectSql2 = "SELECT C.*, G.GRADE, " +
						 			"NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
						   			"FROM CUSTOMER C, CGRADE G " + 
						   			"WHERE C.GNO = G.GNO AND CTEL = ?";

				pstmt = conn.prepareStatement(selectSql1);
				pstmt.setString(1, jtxtTel.getText());
				rs = pstmt.executeQuery();
				
				customer.clear();
				
				if(rs.next()) {
					do {
						int cno = rs.getInt("cno");
						String ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int point = rs.getInt("point");
						int buy = rs.getInt("buy");
						String grade = rs.getString("grade");
						int levelup = rs.getInt("levelup");
						
						customer.add(new Customer(cno, ctel, cname, point, buy, grade, levelup));
					} while (rs.next());
					
				} else {
					jtxtPool.setText("검색 결과가 없습니다.");
				}
				
				rs.close(); // 일단 닫아준다.
				pstmt.close();// 일단 닫아준다.
				
				pstmt = conn.prepareStatement(selectSql2);
				pstmt.setString(1, jtxtTel.getText());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					do {
						int cno = rs.getInt("cno");
						String ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int point = rs.getInt("point");
						int buy = rs.getInt("buy");
						String grade = rs.getString("grade");
						int levelup = rs.getInt("levelup");
						
						
						customer.add(new Customer(cno, ctel, cname, point, buy, grade, levelup));
					} while (rs.next());
					
				} else {
					jtxtPool.setText("검색 결과가 없습니다.");
				}
				
				jtxtPool.setText("[고객ID]   [고객연락처]   [고객명]   [포인트]   [구매총액]   [고객등급]  [다음 레벨업 구매액] \n");
				jtxtPool.append("연락처 검색 결과 \n");
				jtxtPool.append("==================================================================================\n");
				
				if (customer.size() != 0) {
					for (Customer ct : customer) {
						jtxtPool.append(ct.toString());
					}
				} else {
					jtxtPool.append("출력할 결과가 없습니다.");
				}
				
				jtxtTel.setText(""); // 초기화
					
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (SQLException e1) {	System.out.println(e1.getMessage()); }
			}
			
		} else if (e.getSource() == jbtnNameSearch) {// 이름검색
			jtxtPool.setText(""); // 출력 필드초기화
			
			try {
				String selectSql = "SELECT C.*, G.GRADE, " +
								   "NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
								   "FROM CUSTOMER C, CGRADE G " + 
								   "WHERE C.GNO = G.GNO AND CNAME = ?";
				
				pstmt = conn.prepareStatement(selectSql);
				pstmt.setString(1, jtxtName.getText());
				rs = pstmt.executeQuery();
				
				customer.clear(); // 리스트 초기화
				
				while (rs.next()) {
					int cno = rs.getInt("cno");
					String ctel = rs.getString("ctel");
					String cname = rs.getString("cname");
					int point = rs.getInt("point");
					int buy = rs.getInt("buy");
					String grade = rs.getString("grade");
					int levelup = rs.getInt("levelup");
					
					customer.add(new Customer(cno, ctel, cname, point, buy, grade, levelup));
				}
				
				jtxtPool.setText("[고객ID]   [고객연락처]   [고객명]   [포인트]   [구매총액]   [고객등급]  [다음 레벨업 구매액] \n");
				jtxtPool.append("고객명 검색 결과 \n");
				jtxtPool.append("==================================================================================\n");
				
				if (customer.size() != 0) {
					for (Customer ct : customer) {
						jtxtPool.append(ct.toString());
					}
				} else {
					jtxtPool.append("출력할 결과가 없습니다.");
				}
				
				jtxtName.setText(""); // 초기화

			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}  finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
		
		} else if (e.getSource() == jbtnPoint) {// 포인트 구매
			jtxtPool.setText(""); // 출력 필드초기화
			try {
				
				String selectSql = "SELECT POINT FROM CUSTOMER WHERE CNAME = ?";
				
				pstmt = conn.prepareStatement(selectSql);
				pstmt.setString(1, jtxtName.getText());
				rs = pstmt.executeQuery();
				
				int cpoint = 0;
				while (rs.next()) {
					cpoint = rs.getInt("point");
				}
				
				System.out.println(cpoint);
				
				int pointAmount = Integer.parseInt(JtxtAmount.getText());
				// 포인트를 데이터베이스에서 꺼내고 일단 DB 객체들을 닫음.
				rs.close();
				pstmt.close();
								
				if (pointAmount <=  cpoint) { // 포인트가 구매금액 이상일때만 
					String updateSql = "UPDATE CUSTOMER SET BUY = (BUY + ?) , POINT = (POINT - ?) WHERE SUBSTR(CTEL, -4) = ?";
					
					pstmt = conn.prepareStatement(updateSql);
					pstmt.setInt(1, Integer.parseInt(JtxtAmount.getText()));
					pstmt.setInt(2, Integer.parseInt(JtxtAmount.getText()));
					pstmt.setString(3, jtxtTel.getText());
					
					int resulte = pstmt.executeUpdate();
					
					if (resulte > 0) {
						jtxtPool.setText("포인트 구매 성공");
					} else {
						jtxtPool.setText("포인트 구매 실패");
					}
					
					ResetFilde();

				} else {
					jtxtPool.setText("포인트가 구매 금액보다 작습니다.");
					ResetFilde();
				}

			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} catch (NumberFormatException e2) {
				System.out.println(e2.getMessage());
			}  finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
			
		} else if (e.getSource() == jbtnBuy) {// 구매
			jtxtPool.setText(""); // 출력 필드초기화
			
			if (!jtxtTel.getText().equals("") && !JtxtAmount.getText().equals("")) 
			{
				try {
					String updateSql = "UPDATE CUSTOMER SET "
									 + "POINT = POINT + (? * 0.05), "
									 + "BUY = (BUY + ?) "
									 + "WHERE CTEL = ?";
					
					pstmt = conn.prepareStatement(updateSql);
					pstmt.setInt(1, Integer.parseInt(JtxtAmount.getText()));
					pstmt.setInt(2, Integer.parseInt(JtxtAmount.getText()));
					pstmt.setString(3, jtxtTel.getText());
					
					int resulte = pstmt.executeUpdate();
					
					if (resulte > 0) {
						jtxtPool.setText(JtxtAmount.getText() + " 원 구매 성공 했습니다.");
					} else {
						jtxtPool.setText("구매 실패 했습니다.");
					}
					
					pstmt.close();
					
					String updateSql2 = "UPDATE CUSTOMER SET GNO = (SELECT G.GNO FROM CUSTOMER C, CGRADE G " + 
									    "WHERE BUY BETWEEN LOW AND HIGH AND CTEL = ?) " + 
									    "WHERE CTEL= ?";
					
					pstmt = conn.prepareStatement(updateSql2);
					pstmt.setString(1, jtxtTel.getText());
					pstmt.setString(2, jtxtTel.getText());
					
					resulte = pstmt.executeUpdate();
					
					if (resulte > 0) {
						System.out.println("등급 업데이트 성공");
					} else {
						System.out.println("등급 업데이트 실패");
					}

				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
					} catch (Exception e1) { }
				}
			} else {
				jtxtPool.setText("고객 이름과 연락처를  구매 금액을 입력해주세요.");
			}
			
		} else if (e.getSource() == jbtnLevelOutput) {// 등급별 출력
			
			jtxtPool.setText(""); // 출력 필드초기화
			
			if (!jcomLevel.getSelectedItem().toString().equals("")) {
				try {
					String selectSql = "SELECT C.*, G.GRADE, " +
							 			"NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
							   			"FROM CUSTOMER C, CGRADE G " + 
							   			"WHERE C.GNO = G.GNO AND G.GRADE = ? " + 
							   			"ORDER BY CNO";
					
					String grade = jcomLevel.getSelectedItem().toString();
					System.out.println(grade);
					
					pstmt = conn.prepareStatement(selectSql);
					pstmt.setString(1, grade);
					rs = pstmt.executeQuery();
					customer.clear();
						while (rs.next()) {
							int cno = rs.getInt("cno");
							String ctel = rs.getString("ctel");
							String cname = rs.getString("cname");
							int point = rs.getInt("point");
							int buy = rs.getInt("buy");
							grade = rs.getString("grade");
							int levelup = rs.getInt("levelup");
							
							customer.add(new Customer(cno, ctel, cname, point, buy, grade, levelup));
						}
	
						jtxtPool.setText("[고객ID]   [고객연락처]   [고객명]   [포인트]   [구매총액]   [고객등급]  [다음 레벨업 구매액] \n");
					jtxtPool.append("==================================================================================\n");
					
					if (customer.size() != 0) {
						for (Customer ct : customer) {
							jtxtPool.append(ct.toString());
						}
					} else {
						jtxtPool.append("출력할 결과가 없습니다.");
					}
					
					ResetFilde(); // 입력필드들 초기화
					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
					} catch (Exception e1) { }
				}
			} else {
				jtxtPool.setText("출력할 등급을 선택해주세요.");
			}
		
		} else if (e.getSource() == jbtnAlloutput) {// 전체 출력
			jtxtPool.setText(""); // 출력 필드초기화

			try {
				String selectSql = "SELECT C.*, G.GRADE, " +
								   "NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
								   "FROM CUSTOMER C, CGRADE G " + 
								   "WHERE C.GNO = G.GNO " + 
								   "ORDER BY C.CNO";
				
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();
				
				customer.clear(); // 리스트 초기화
				
				while (rs.next()) {
					int cno = rs.getInt("cno");
					String ctel = rs.getString("ctel");
					String cname = rs.getString("cname");
					int point = rs.getInt("point");
					int buy = rs.getInt("buy");
					String grade = rs.getString("grade");
					int levelup = rs.getInt("levelup");
					
					customer.add(new Customer(cno, ctel, cname, point, buy, grade, levelup));
				}
				
				jtxtPool.setText("[고객ID]   [고객연락처]   [고객명]   [포인트]   [구매총액]   [고객등급]  [다음 레벨업 구매액] \n");
				jtxtPool.append("==================================================================================\n");
				
				if (customer.size() != 0) {
					for (Customer ct : customer) {
						jtxtPool.append(ct.toString());
					}
				} else {
					jtxtPool.append("출력할 결과가 없습니다.");
				}
				
				ResetFilde();
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}  finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
			
		} else if (e.getSource() == jbtnInsert) {// 회원가입
			jtxtPool.setText(""); // 출력 필드초기화
			
			if (!jtxtTel.getText().equals("") && !jtxtName.getText().equals("")) {
				try {
					String insertSql = "INSERT INTO CUSTOMER VALUES "
							+ "(SEQ_CNO.NEXTVAL, ?, ?, 1000, 0, 1)";
					
					pstmt = conn.prepareStatement(insertSql);
					pstmt.setString(1, jtxtTel.getText());
					pstmt.setString(2, jtxtName.getText());
					
					int resulte = pstmt.executeUpdate(); 
					
					if (resulte > 0) {
						jtxtPool.setText(jtxtName.getText() + "님 회원가입되셨습니다. 감사합니다.");
					} else {
						jtxtPool.setText(jtxtName.getText() + "님 회원가입 실패하였습니다.");
					}
					
					ResetFilde();
					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
					} catch (Exception e1) { }
				}
			} else {
				jtxtPool.setText("고객 이름과 연락처를 입력해주세요.");
			}
			
		} else if (e.getSource() == jbtnTelupdate) {// 번호수정
			jtxtPool.setText(""); // 출력 필드초기화
			
			try {
				
				String updateSql = "UPDATE CUSTOMER SET CTEL = ? WHERE CNAME = ?";
				
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, jtxtTel.getText());
				pstmt.setString(2, jtxtName.getText());
				
				int resulte = pstmt.executeUpdate();
				
				if (resulte > 0) {
					jtxtPool.setText(jtxtName.getText()+ " 님의 연락처가 " + jtxtTel.getText() + " 로 변경되었습니다.");
				} else {
					jtxtPool.setText("연락처 변경에 실패했습니다.");
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
			
		} else if (e.getSource() == jbtnDelete) {// 회원탈퇴
			jtxtPool.setText(""); // 출력 필드초기화
			
			try {
				String deleteSql = "DELETE FROM CUSTOMER WHERE CNAME = ?";

				pstmt = conn.prepareStatement(deleteSql);
				pstmt.setString(1, jtxtName.getText());
				int resulte = pstmt.executeUpdate();
				
				if (resulte > 0) {
					jtxtPool.setText("회원탈퇴 성공 : " + jtxtName.getText());
				} else {
					jtxtPool.setText("회원탈퇴 실패 : " + jtxtName.getText());
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
			
		} else if (e.getSource() == jbtnExit) {// 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}
