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
	String driver = "oracle.jdbc.driver.OracleDriver"; // Driver
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // URL
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ArrayList<Customer> customer;
	
	public SuperMarket() {
		customer = new ArrayList<Customer>();
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		items.add(""); // 0�� �ε���
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
		jcomLevel = new JComboBox<String>(items); // �޺��ڽ�
		
		jbtnTelSearch = new JButton("�� �� 4�ڸ� �˻�");
		jbtnNameSearch = new JButton("�� �̸� �˻�");
		jbtnPoint = new JButton("����Ʈ�θ�  ����");
		
		jbtnBuy = new JButton("��ǰ ����");
		jbtnLevelOutput = new JButton("��޺� ���");
		jbtnAlloutput = new JButton("��ü���");
		jbtnInsert = new JButton("ȸ������");
		jbtnTelupdate = new JButton("��ȣ����");
		jbtnDelete = new JButton("ȸ��Ż��");
		jbtnExit = new JButton("������");
		
		jpup.add(new JLabel("����ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("���̸�", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(JtxtAmount);
		jpup.add(new JLabel("", (int) CENTER_ALIGNMENT));
		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
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
		
		int width = 700, height = 450; // window size Dimension variable
		
		setSize(new Dimension(width, height));
		setLocation(400, 300);
		setVisible(true);
		
		// ������
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jbtnTelSearch) { // ����ó �˻� 
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			
			try {
				String selectSql1 = "SELECT C.*, G.GRADE, " +
								    "NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
								    "FROM CUSTOMER C, CGRADE G " + 
								    "WHERE C.GNO = G.GNO AND CTEL LIKE '%' || ? ";
				String cTel = jtxtTel.getText().trim();
				pstmt = conn.prepareStatement(selectSql1);
				pstmt.setString(1, cTel);
				
				if(!cTel.equals("")) {
					rs = pstmt.executeQuery();
				} else {
					jtxtPool.setText("����ȣ�� �Է����ּ���.");
				}
				customer.clear();
				
				if(rs.next()) {
					do {
						int cno = rs.getInt("cno");
						String ctel = rs.getString("ctel");
						jtxtTel.setText(ctel);
						String cname = rs.getString("cname");
						jtxtName.setText(cname);
						int point = rs.getInt("point");
						jtxtPoint.setText(String.valueOf(point));
						int buy = rs.getInt("buy");
						String grade = rs.getString("grade");
						jcomLevel.setSelectedItem(grade);
						int levelup = rs.getInt("levelup");
						
						customer.add(new Customer(cno, ctel, cname, point, buy, grade, levelup));
					} while (rs.next());
				} else {
					jtxtPool.setText("�˻� ����� �����ϴ�.");
				}
				
				jtxtPool.setText("[��ID]   [������ó]   [����]   [����Ʈ]   [�����Ѿ�]   [�����]  [���� ������ ���ž�] \n");
				jtxtPool.append("����ó �˻� ��� \n");
				jtxtPool.append("==================================================================================\n");
				
				if (customer.size() != 0) {
					for (Customer ct : customer) {
						jtxtPool.append(ct.toString());
					}
				} else {
					jtxtPool.append("����� ����� �����ϴ�.");
				}
									
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (SQLException e1) {	System.out.println(e1.getMessage()); }
			}
			
		} else if (e.getSource() == jbtnNameSearch) {// �̸��˻�
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			
			try {
				String selectSql = "SELECT C.*, G.GRADE, " +
								   "NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
								   "FROM CUSTOMER C, CGRADE G " + 
								   "WHERE C.GNO = G.GNO AND CNAME = ?";
				
				pstmt = conn.prepareStatement(selectSql);
				pstmt.setString(1, jtxtName.getText().trim());
				rs = pstmt.executeQuery();
				
				customer.clear(); // ����Ʈ �ʱ�ȭ
				
				while (rs.next()) {
					int cno = rs.getInt("cno");
					String ctel = rs.getString("ctel");
					jtxtTel.setText(ctel);
					String cname = rs.getString("cname");
					jtxtName.setText(cname);
					int point = rs.getInt("point");
					jtxtPoint.setText(""+point);
					int buy = rs.getInt("buy");
					String grade = rs.getString("grade");
					jcomLevel.setSelectedItem(grade);
					int levelup = rs.getInt("levelup");
					
					customer.add(new Customer(cno, ctel, cname, point, buy, grade, levelup));
				}
				
				jtxtPool.setText("[��ID]   [������ó]   [����]   [����Ʈ]   [�����Ѿ�]   [�����]  [���� ������ ���ž�] \n");
				jtxtPool.append("���� �˻� ��� \n");
				jtxtPool.append("==================================================================================\n");
				
				if (customer.size() != 0) {
					for (Customer ct : customer) {
						jtxtPool.append(ct.toString());
					}
				} else {
					jtxtPool.append("����� ����� �����ϴ�.");
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}  finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
		
		} else if (e.getSource() == jbtnPoint) {// ����Ʈ ����
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			try {
				
				String selectSql = "SELECT POINT FROM CUSTOMER WHERE CTEL LIKE '%' || ?";
				
				pstmt = conn.prepareStatement(selectSql);
				pstmt.setString(1, jtxtTel.getText().trim());
				rs = pstmt.executeQuery();
				
				int cpoint = 0;
				while (rs.next()) {
					cpoint = rs.getInt("point");
				}
				
				System.out.println(cpoint);
				
				int pointAmount = Integer.parseInt(JtxtAmount.getText().trim());
				
				// ����Ʈ�� �����ͺ��̽����� ������ �ϴ� DB ��ü���� ����.
				rs.close();
				pstmt.close();

				if (cpoint >=  pointAmount) { // ����Ʈ�� ���űݾ� �̻��϶��� 
					
					String updateSql = "UPDATE CUSTOMER SET BUY = (BUY + ?), POINT = (POINT - ?) WHERE CTEL LIKE '%'||?";
					
					pstmt = conn.prepareStatement(updateSql);
					pstmt.setInt(1, pointAmount);
					pstmt.setInt(2, pointAmount);
					pstmt.setString(3, jtxtTel.getText().trim());
					
					int resulte = pstmt.executeUpdate();
					
					if (resulte > 0) {
						jtxtPool.setText("����Ʈ ���� ����" + pointAmount + " ����Ʈ ����");
					} else {
						jtxtPool.setText("����Ʈ ���� ����");
					}
					
					ResetField();

				} else {
					jtxtPool.setText("����Ʈ�� ���� �ݾ׺��� �۽��ϴ�.");
					ResetField();
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
			
		} else if (e.getSource() == jbtnBuy) {// ����
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			
			if (!jtxtTel.getText().equals("") && !JtxtAmount.getText().equals("")) 
			{
				try {
					String updateSql = "UPDATE CUSTOMER SET "
									 + "POINT = POINT + (? * 0.05), "
									 + "BUY = (BUY + ?) "
									 + "WHERE CTEL LIKE '%'||?";
					
					pstmt = conn.prepareStatement(updateSql);
					pstmt.setInt(1, Integer.parseInt(JtxtAmount.getText().trim()));
					pstmt.setInt(2, Integer.parseInt(JtxtAmount.getText().trim()));
					pstmt.setString(3, jtxtTel.getText().trim());
					
					int resulte = pstmt.executeUpdate();
					
					if (resulte > 0) {
						jtxtPool.setText(jtxtTel.getText().trim() + " ���� " + JtxtAmount.getText().trim() + " �� ���� �ϼ̽��ϴ�.");
					} else {
						jtxtPool.setText("���� ���� �߽��ϴ�.");
					}
					
					pstmt.close();
					
					String updateSql2 = "UPDATE CUSTOMER SET GNO = (SELECT G.GNO FROM CUSTOMER C, CGRADE G " + 
									    "WHERE BUY BETWEEN LOW AND HIGH AND CTEL LIKE '%'|| ?) " + 
									    "WHERE CTEL LIKE '%'||?";
					
					pstmt = conn.prepareStatement(updateSql2);
					pstmt.setString(1, jtxtTel.getText().trim());
					pstmt.setString(2, jtxtTel.getText().trim());
					
					resulte = pstmt.executeUpdate();
					
					if (resulte > 0) {
						System.out.println("��� ������Ʈ ����");
					} else {
						System.out.println("��� ������Ʈ ����");
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
				jtxtPool.setText("�� ����ó, ���� �ݾ��� �Է����ּ���.");
			}
			
		} else if (e.getSource() == jbtnLevelOutput) {// ��޺� ���
			
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			
			if (!jcomLevel.getSelectedItem().toString().equals("")) {
				try {
					String selectSql = "SELECT C.*, G.GRADE, " +
							 		   "NVL((SELECT HIGH - BUY + 1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
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
	
					jtxtPool.setText("[��ID]   [������ó]   [����]   [����Ʈ]   [�����Ѿ�]   [�����]  [���� ������ ���ž�] \n");
					jtxtPool.append(grade + "��� �˻� ��� \n");
					jtxtPool.append("==================================================================================\n");
					
					if (customer.size() != 0) {
						for (Customer ct : customer) {
							jtxtPool.append(ct.toString());
						}
					} else {
						jtxtPool.append("����� ����� �����ϴ�.");
					}
					
					ResetField(); // �Է��ʵ�� �ʱ�ȭ
					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
					} catch (Exception e1) { }
				}
			} else {
				jtxtPool.setText("����� ����� �������ּ���.");
			}
		
		} else if (e.getSource() == jbtnAlloutput) {// ��ü ���
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ

			try {
				String selectSql = "SELECT C.*, G.GRADE, " +
								   "NVL((SELECT HIGH-BUY+1 from CUSTOMER WHERE CNO = C.CNO and GNO != 5), 0) LEVELUP " + 
								   "FROM CUSTOMER C, CGRADE G " + 
								   "WHERE C.GNO = G.GNO " + 
								   "ORDER BY C.CNO";
				
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();
				
				customer.clear(); // ����Ʈ �ʱ�ȭ
				
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
				
				jtxtPool.setText("[��ID]   [������ó]   [����]   [����Ʈ]   [�����Ѿ�]   [�����]  [���� ������ ���ž�] \n");
				jtxtPool.append("��ü ȸ���� ����մϴ�.\n");
				jtxtPool.append("==================================================================================\n");
				
				if (customer.size() != 0) {
					for (Customer ct : customer) {
						jtxtPool.append(ct.toString());
					}
				} else {
					jtxtPool.append("����� ����� �����ϴ�.");
				}
				
				ResetField();
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}  finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
			
		} else if (e.getSource() == jbtnInsert) {// ȸ������
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			
			if (!jtxtTel.getText().equals("") && !jtxtName.getText().equals("")) {
				try {
					String insertSql = "INSERT INTO CUSTOMER VALUES "
									 + "(SEQ_CNO.NEXTVAL, ?, ?, 1000, 0, 1)";
					
					pstmt = conn.prepareStatement(insertSql);
					pstmt.setString(1, jtxtTel.getText().trim());
					pstmt.setString(2, jtxtName.getText().trim());
					
					int resulte = pstmt.executeUpdate(); 
					
					if (resulte > 0) {
						jtxtPool.setText(jtxtName.getText().trim() + "�� ȸ�����ԵǼ̽��ϴ�. �����մϴ�.");
					} else {
						jtxtPool.setText(jtxtName.getText().trim() + "�� ȸ������ �����Ͽ����ϴ�.");
					}
					
					ResetField();
					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
					} catch (Exception e1) { }
				}
			} else {
				jtxtPool.setText("�� �̸��� ����ó�� �Է����ּ���.");
			}
			
		} else if (e.getSource() == jbtnTelupdate) {// ��ȣ����
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			
			try {
				
				String updateSql = "UPDATE CUSTOMER SET CTEL = ? WHERE CNAME = ?";
				
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, jtxtTel.getText().trim());
				pstmt.setString(2, jtxtName.getText().trim());
				
				int resulte = pstmt.executeUpdate();
				
				if (resulte > 0) {
					jtxtPool.setText(jtxtName.getText().trim() + " ���� ����ó�� " + jtxtTel.getText().trim() + " �� ����Ǿ����ϴ�.");
				} else {
					jtxtPool.setText("����ó ���濡 �����߽��ϴ�.");
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) { }
			}
			
		} else if (e.getSource() == jbtnDelete) {// ȸ��Ż��
			jtxtPool.setText(""); // ��� �ʵ��ʱ�ȭ
			
			if(!jtxtTel.getText().equals("")) {
				try {
					String deleteSql = "DELETE FROM CUSTOMER WHERE CTEL = ?";
	
					pstmt = conn.prepareStatement(deleteSql);
					pstmt.setString(1, jtxtTel.getText().trim());
					int resulte = pstmt.executeUpdate();
					
					if (resulte > 0) {
						jtxtPool.setText("ȸ��Ż�� ���� : " + jtxtTel.getText().trim());
					} else {
						jtxtPool.setText("ȸ��Ż�� ���� : " + jtxtTel.getText().trim());
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
				jtxtPool.setText("Ż���� ���� ����ó�� �Է����ּ���.");
			}
			
		} else if (e.getSource() == jbtnExit) {// ����
			
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {}
			
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	private void ResetField() {
		jtxtTel.setText(""); // �ʱ�ȭ
		jtxtName.setText("");
		jtxtPoint.setText("");
		JtxtAmount.setText("");
		jcomLevel.setSelectedIndex(0);
	}
	
}
