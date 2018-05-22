package com.tj.ex1homework1;

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

public class StudentManager extends JFrame implements ActionListener {
	// GUI Variable
	private Container containPane;
	private JPanel jpup, jp1, jp2;
	private JScrollPane scrollpane;
	private JTextArea txtPool;
	private JTextField txtNo, txtName, txtscore;
	private JComboBox<String> comMajor;
	private Vector<String> items;
	private JButton btnNoSearch, btnNameSearch, btnMajorSearch;
	private JButton btnInput, btnUpdate, btnStudentOut;
	private JButton btnExpel, btnExit, btnExpelOut;
	
	// DB variable
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ArrayList<Student> student;
	
	public StudentManager(String title){
		this();
		setTitle(title);
	}
	
	public StudentManager() {
		student = new ArrayList<Student>(); 
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 창에 필요한 객체들 생성.
		containPane = getContentPane();
		containPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4, 3));
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		
		btnNoSearch = new JButton("학번검색");
		btnNameSearch = new JButton("이름검색");
		btnMajorSearch = new JButton("전공검색");
		
		// table에서 백터를 가져와서 combobox 의 요소로 넣는 코드
		items = new Vector<String>();
		items.add("");
		try {
			
			String sql = "SELECT MNAME FROM MAJOR";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				items.add(rs.getString("mname"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) { System.out.println(e.getMessage());}
		}
		
		comMajor = new JComboBox<String>(items);
		
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		btnExpelOut = new JButton("제적자출력");
		
		txtPool = new JTextArea(7, 40);
		scrollpane = new JScrollPane(txtPool);
		
		txtNo = new JTextField();
		txtName = new JTextField();
		txtscore = new JTextField();
		
		// 창 구성
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtNo);
		jpup.add(btnNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(btnNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(btnMajorSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
		jpup.add(txtscore);
		
		jp1.add(btnInput);
		jp1.add(btnUpdate);
		jp1.add(btnStudentOut);
		
		jp2.add(btnExpel);
		jp2.add(btnExpelOut);
		jp2.add(btnExit);
		
		containPane.add(jpup);
		containPane.add(jp1);
		containPane.add(jp2);
		containPane.add(scrollpane);
		
		setSize(new Dimension(500, 400));
		setLocation(400, 300);
		setVisible(true);
		
		btnNoSearch.addActionListener(this);
		btnNameSearch.addActionListener(this);
		btnMajorSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExit.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {// 버튼 이벤트 로직
		if(e.getSource() == btnNoSearch) {// 학번검색
			String sno;//학번
			
			txtPool.setText("");

			if (txtNo.getText().trim().length() != 0) {
				System.out.println("검색합니다.");
				
				sno = txtNo.getText().trim();
				sno = sno.toUpperCase(); // 대문자 변경
				
				try {
					
					String selectSql = "SELECT S.*, MNAME " + 
										"FROM STUDENT S, MAJOR M " + 
										"WHERE S.MNO = M.MNO AND SNO = ?";
					
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "leos", "Stonker26");
					pstmt = conn.prepareStatement(selectSql);
					pstmt.setString(1, sno);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						do {
							Student s = new Student();
							
							s.setSno(rs.getString("sno"));
							s.setSname(rs.getString("sname"));
							s.setScore(rs.getInt("score"));
							s.setMname(rs.getString("mname"));
							
							txtNo.setText(rs.getString("sno"));
							txtName.setText(rs.getString("sname"));
							comMajor.setSelectedItem(rs.getString("mname"));
							txtscore.setText(String.valueOf(rs.getInt("score")));
							
							txtPool.append(s.toString());
						} while(rs.next());
					} else {
						txtPool.setText("검색 결과가 없습니다.");
					}
					

					
				} catch (ClassNotFoundException e1) {
					System.out.println(e1.getMessage());
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) rs.close();
						if (conn != null) rs.close();
					} catch (Exception e1) {}
				}
				
			} else {
				txtPool.setText("학번을 입력하고 검색하세요.");
			}
			
		} else if(e.getSource() == btnNameSearch) {// 이름검색
			
			String sname;//이름
			
			txtPool.setText("");

			if (txtName.getText().trim().length() != 0) {
				System.out.println("검색합니다.");
				
				sname = txtName.getText().trim();
				try {
					
					String selectSql = "SELECT S.*, MNAME " + 
										"FROM STUDENT S, MAJOR M " + 
										"WHERE S.MNO = M.MNO AND SNAME = ?";
					
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "leos", "Stonker26");
					pstmt = conn.prepareStatement(selectSql);
					pstmt.setString(1, sname);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						do {
							Student s = new Student();
							
							s.setSno(rs.getString("sno"));
							s.setSname(rs.getString("sname"));
							s.setScore(rs.getInt("score"));
							s.setMname(rs.getString("mname"));
							
							txtNo.setText(rs.getString("sno"));
							txtName.setText(rs.getString("sname"));
							comMajor.setSelectedItem(rs.getString("mname"));
							txtscore.setText(String.valueOf(rs.getInt("score")));
							
							txtPool.append(s.toString());
						} while(rs.next());
					} else {
						txtPool.setText("검색 결과가 없습니다.");
					}
					
					
				} catch (ClassNotFoundException e1) {
					System.out.println(e1.getMessage());
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) rs.close();
						if (conn != null) rs.close();
					} catch (Exception e1) {}
				}
				
			} else {
				txtPool.setText("이름을 입력하고 검색하세요.");
			}

		} else if(e.getSource() == btnMajorSearch) {// 학과검색
			
			String mname;//학과선택
			
			txtPool.setText("");

			if (comMajor.getSelectedIndex() != 0) {
				System.out.println("검색합니다.");
				
				mname = comMajor.getSelectedItem().toString();
				
				try {
					
					String selectSql = "SELECT S.*, MNAME " + 
										"FROM STUDENT S, MAJOR M " + 
										"WHERE S.MNO = M.MNO AND MNAME = ?";
					
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "leos", "Stonker26");
					pstmt = conn.prepareStatement(selectSql);
					pstmt.setString(1, mname);
					rs = pstmt.executeQuery();
										
					if (rs.next()) {
						 do {
							Student s = new Student();
							
							s.setSno(rs.getString("sno"));
							s.setSname(rs.getString("sname"));
							s.setScore(rs.getInt("score"));
							s.setMname(rs.getString("mname"));
							
							txtPool.append(s.toString());
						} while(rs.next());
					} else {
						txtPool.setText("검색 결과가 없습니다.");
					}
					
					txtNo.setText("");
					txtName.setText("");
					comMajor.setSelectedIndex(0);
					txtscore.setText("");
					
				} catch (ClassNotFoundException e1) {
					System.out.println(e1.getMessage());
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) rs.close();
						if (conn != null) rs.close();
					} catch (Exception e1) {}
				}
				
			} else {
				txtPool.setText("전공을 선택하고 검색하세요.");
			}
			
		} else if(e.getSource() == btnInput) {// 학생정보 입력
			
			String sno, sname, mno;
			int score;
			
			sno = txtNo.getText().trim();
			sname = txtName.getText().trim();
			mno = comMajor.getSelectedItem().toString();
			
			try {
				score = Integer.parseInt(txtscore.getText().trim());
			} catch (Exception e1) {
				System.out.println("숫자를 입력하지 않았기 때문에 점수를 0으로 입력합니다");
				score = 0;
			}
			
			try {
				
				String insertSql = "INSERT INTO STUDENT VALUES (UPPER(?), ?, (SELECT MNO FROM MAJOR WHERE MNAME = ?), ?, ?)";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setString(1, sno);
				pstmt.setString(2, sname);
				pstmt.setString(3, mno);
				pstmt.setInt(4, score);
				pstmt.setInt(5, 0);
				
				int resulte = pstmt.executeUpdate();
				
				if(resulte > 0) {
					txtPool.setText("입력성공");
				} else {	
					txtPool.setText("입력 실패");
				}
				
				txtNo.setText("");
				txtName.setText("");
				comMajor.setSelectedIndex(0);
				txtscore.setText("");
				
			} catch (ClassNotFoundException e1) {
				System.out.println(e1.getMessage() + "Driver Error");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL Error");
			} finally {
				try {
					if (pstmt != null) rs.close();
					if (conn != null) rs.close();
				} catch (Exception e1) {}
			}
			
		} else if(e.getSource() == btnUpdate) {// 학생정보 수정
			
			try {
				String updateSql = "UPDATE STUDENT SET "
				+ "SNAME = ?, MNO = (SELECT MNO FROM MAJOR WHERE MNAME = ?), SCORE = ? WHERE SNO = UPPER(?)";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, txtName.getText());
				pstmt.setString(2, comMajor.getSelectedItem().toString());
				pstmt.setInt(3, Integer.parseInt(txtscore.getText()));
				pstmt.setString(4, txtNo.getText());
				
				int resulte = pstmt.executeUpdate();
				
				if(resulte > 0) {
					txtPool.setText("학생 정보 수정 성공");
				} else {	
					txtPool.setText("학생 정보 수정 실패");
				}
				
			} catch (ClassNotFoundException e1) {
				System.out.println(e1.getMessage() + "Driver Error");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL Error");
			} finally {
				try {
					if (pstmt != null) rs.close();
					if (conn != null) rs.close();
				} catch (Exception e1) {}
			}
			
		} else if(e.getSource() == btnStudentOut) {// 학생정보 출력
			
			txtPool.setText("");

			try {
				
				String selectSql = "SELECT S.*, MNAME " + 
									"FROM STUDENT S, MAJOR M " + 
									"WHERE S.MNO = M.MNO AND EXPEL = 0 ORDER BY S.SNO";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					 do {
						Student s = new Student();
						
						s.setSno(rs.getString("sno"));
						s.setSname(rs.getString("sname"));
						s.setScore(rs.getInt("score"));
						s.setMname(rs.getString("mname"));
						
						txtPool.append(s.toString());
					} while(rs.next());
				} else {
					txtPool.setText("출력 할 학생이 없습니다.");
				}
				
				txtNo.setText("");
				txtName.setText("");
				comMajor.setSelectedIndex(0);
				txtscore.setText("");
				
			} catch (ClassNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) rs.close();
					if (conn != null) rs.close();
				} catch (Exception e1) {}
			}
			
		} else if(e.getSource() == btnExpel) {// 제적처리
			
			try {
				String updateSql = "UPDATE STUDENT SET EXPEL = 1 WHERE SNO = UPPER(?)";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, txtNo.getText());
				
				int resulte = pstmt.executeUpdate();
				
				if(resulte > 0) {
					txtPool.setText("재적 처리 성공");
				} else {	
					txtPool.setText("재적 처리 실패");
				}
				
			} catch (ClassNotFoundException e1) {
				System.out.println(e1.getMessage() + "Driver Error");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL Error");
			} finally {
				try {
					if (pstmt != null) rs.close();
					if (conn != null) rs.close();
				} catch (Exception e1) {}
			}
			
		} else if(e.getSource() == btnExpelOut) {// 제적자 출력
			
			txtPool.setText("");

			try {
				
				String selectSql = "SELECT S.*, MNAME " + 
								   "FROM STUDENT S, MAJOR M " + 
								   "WHERE S.MNO = M.MNO AND EXPEL = 1 ORDER BY S.SNO";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					 do {
						Student s = new Student();
						
						s.setSno(rs.getString("sno"));
						s.setSname(rs.getString("sname"));
						s.setScore(rs.getInt("score"));
						s.setMname(rs.getString("mname"));
						
						txtPool.append(s.toString());
					} while(rs.next());
				} else {
					txtPool.setText("출력 할 재적자가 없습니다.");
				}
				
				txtNo.setText("");
				txtName.setText("");
				comMajor.setSelectedIndex(0);
				txtscore.setText("");
				
			} catch (ClassNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) rs.close();
					if (conn != null) rs.close();
				} catch (Exception e1) {}
			}
			
		} else if(e.getSource() == btnExit) {// 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}

}
