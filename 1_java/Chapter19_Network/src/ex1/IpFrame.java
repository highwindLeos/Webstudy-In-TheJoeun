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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â ����
		
		contanPane = getContentPane();
		contanPane.setLayout(new FlowLayout());
		
		jpUp = new JPanel();
		jpDown = new JPanel();
		
		jtextIn = new JTextField(20); // 20�� ���� �ԷµǴ� field
		
		icon = new ImageIcon("src/mac-mini.png");
		btnSerach = new JButton("�����˻�", icon);
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
		
		setResizable(false); // âũ�� ���� X
		setVisible(true); // â ���̰� Ȱ��ȭ
		
		btnSerach.addActionListener(this); // �̺�Ʈ�� �����ϴ� �����ʸ� �߰��Ѵ�.
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnSerach) {
			String domainName = jtextIn.getText().trim();
			
			if(domainName.equals("")) {
				jTextResulte.setText("�ּҸ� �Է����ּ���.");
				return; // �Լ��� ����. �Ʒ� �ڵ���� ������� �ʴ´�.
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
				jTextResulte.setText("��ȿ�� �ּҰ� �ƴմϴ�.");
				System.out.println(e.getMessage());
			}
		}
	}

}
