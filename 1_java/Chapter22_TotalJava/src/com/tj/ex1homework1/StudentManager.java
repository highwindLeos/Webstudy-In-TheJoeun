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
		// â�� �ʿ��� ��ü�� ����.
		containPane = getContentPane();
		containPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4, 3));
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		
		btnNoSearch = new JButton("�й��˻�");
		btnNameSearch = new JButton("�̸��˻�");
		btnMajorSearch = new JButton("�����˻�");
		
		// table���� ���͸� �����ͼ� combobox �� ��ҷ� �ִ� �ڵ�
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
		
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		btnExpelOut = new JButton("���������");
		
		txtPool = new JTextArea(7, 40);
		scrollpane = new JScrollPane(txtPool);
		
		txtNo = new JTextField();
		txtName = new JTextField();
		txtscore = new JTextField();
		
		// â ����
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtNo);
		jpup.add(btnNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(btnNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(btnMajorSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
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
	public void actionPerformed(ActionEvent e) {// ��ư �̺�Ʈ ����
		if(e.getSource() == btnNoSearch) {// �й��˻�
			String sno;//�й�
			
			txtPool.setText("");

			if (txtNo.getText().trim().length() != 0) {
				System.out.println("�˻��մϴ�.");
				
				sno = txtNo.getText().trim();
				sno = sno.toUpperCase(); // �빮�� ����
				
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
						txtPool.setText("�˻� ����� �����ϴ�.");
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
				txtPool.setText("�й��� �Է��ϰ� �˻��ϼ���.");
			}
			
		} else if(e.getSource() == btnNameSearch) {// �̸��˻�
			
			String sname;//�̸�
			
			txtPool.setText("");

			if (txtName.getText().trim().length() != 0) {
				System.out.println("�˻��մϴ�.");
				
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
						txtPool.setText("�˻� ����� �����ϴ�.");
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
				txtPool.setText("�̸��� �Է��ϰ� �˻��ϼ���.");
			}

		} else if(e.getSource() == btnMajorSearch) {// �а��˻�
			
			String mname;//�а�����
			
			txtPool.setText("");

			if (comMajor.getSelectedIndex() != 0) {
				System.out.println("�˻��մϴ�.");
				
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
						txtPool.setText("�˻� ����� �����ϴ�.");
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
				txtPool.setText("������ �����ϰ� �˻��ϼ���.");
			}
			
		} else if(e.getSource() == btnInput) {// �л����� �Է�
			
			String sno, sname, mno;
			int score;
			
			sno = txtNo.getText().trim();
			sname = txtName.getText().trim();
			mno = comMajor.getSelectedItem().toString();
			
			try {
				score = Integer.parseInt(txtscore.getText().trim());
			} catch (Exception e1) {
				System.out.println("���ڸ� �Է����� �ʾұ� ������ ������ 0���� �Է��մϴ�");
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
					txtPool.setText("�Է¼���");
				} else {	
					txtPool.setText("�Է� ����");
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
			
		} else if(e.getSource() == btnUpdate) {// �л����� ����
			
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
					txtPool.setText("�л� ���� ���� ����");
				} else {	
					txtPool.setText("�л� ���� ���� ����");
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
			
		} else if(e.getSource() == btnStudentOut) {// �л����� ���
			
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
					txtPool.setText("��� �� �л��� �����ϴ�.");
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
			
		} else if(e.getSource() == btnExpel) {// ����ó��
			
			try {
				String updateSql = "UPDATE STUDENT SET EXPEL = 1 WHERE SNO = UPPER(?)";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "leos", "Stonker26");
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, txtNo.getText());
				
				int resulte = pstmt.executeUpdate();
				
				if(resulte > 0) {
					txtPool.setText("���� ó�� ����");
				} else {	
					txtPool.setText("���� ó�� ����");
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
			
		} else if(e.getSource() == btnExpelOut) {// ������ ���
			
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
					txtPool.setText("��� �� �����ڰ� �����ϴ�.");
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
			
		} else if(e.getSource() == btnExit) {// ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}

}
