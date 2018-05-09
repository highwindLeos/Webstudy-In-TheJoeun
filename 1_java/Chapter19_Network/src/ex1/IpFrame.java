package ex1;

import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;


public class IpFrame extends JFrame implements ActionListener {
	
	private Container contanPane;
	private JPanel jpUp,jpDown;
	private ImageIcon icon;
	private JButton btnSerach;
	private JTextField jtextIn;
	private JTextArea jTextResulte;
	
	public IpFrame() {	}
	
	public IpFrame(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 끄기
		
		contanPane = getContentPane();
		contanPane.setLayout(new FlowLayout());
		
		jpUp = new JPanel();
		jpDown = new JPanel();
		
		jtextIn = new JTextField(20); // 20자 까지 입력되는 field
		
		icon = new ImageIcon("src/mac-mini.png");
		btnSerach = new JButton("정보검색", icon);
		jTextResulte = new JTextArea(4, 20);
		
		jpUp.add(new JLabel("host name"));
		jpUp.add(jtextIn);
		
		jpDown.add(new JLabel("host infomation"));
		jpDown.add(jTextResulte);
		
		btnSerach.setPreferredSize(new Dimension(180, 80));
		
		contanPane.add(jpUp);
		contanPane.add(btnSerach);
		contanPane.add(jpDown);
		
		setSize(new Dimension(400, 280));
		setLocation(new Point(400, 400));
		
		setResizable(false); // 창크기 조절 X
		setVisible(true); // 창 보이게 활성화
		
		btnSerach.addActionListener(this); // 이벤트를 감지하는 리스너를 추가한다.
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnSerach) {
			String domainName = jtextIn.getText().trim();
			
			if(domainName.equals("")) {
				jTextResulte.setText("주소를 입력해주세요.");
				return; // 함수를 종료. 아래 코드들이 수행되지 않는다.
			}
			
			String temp;
			try {
				InetAddress inetAddress = InetAddress.getByName(domainName);
				
				temp = "Computer Name : " + inetAddress.getHostName() + "\n";
				temp += "Computer IP : " + inetAddress.getHostAddress() + "\n";
				temp += "Local Name IP : " + InetAddress.getLoopbackAddress() + "\n";
				temp += "Local IPv4 : " + InetAddress.getLocalHost() +"\n"; 
				
				jTextResulte.setText(temp);
			} catch (UnknownHostException e) {
				jTextResulte.setText("유효한 주소가 아닙니다.");
				System.out.println(e.getMessage());
			}
		}
	}

}
