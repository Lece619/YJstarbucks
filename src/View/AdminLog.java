package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class AdminLog extends JFrame implements ActionListener{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	JLabel logoLabel = new JLabel();
	

	private String adminPw = "1234";

	
	Color sbC = new Color(1,98,65);
	Font font = new Font("Courier",Font.PLAIN,screenWidth/25);
	
	JPanel topPanel = new JPanel();
	JPasswordField pwField = new JPasswordField();
//	JButton login = new JButton("Login");
//	RoundedButton login = new RoundedButton("Login");
	
	JButton login = new JButton("Login");
	JLabel pwArea = new JLabel("관리자 비밀번호 입력");
	
	FlowLayout fl = new FlowLayout();
	GridLayout gl = new GridLayout(4,0);
	
	
	public AdminLog() {};
	
	public void startAdminLog() {
		setTitle("스타벅스 관리자 로그인 페이지");
		setSize((screenWidth*2)/3,screenHeight/2);
		setResizable(false);
		setLayout(gl);
		setLocationRelativeTo(null);
		
		topPanel.setPreferredSize(new Dimension(screenWidth,screenHeight/10));
		topPanel.setBackground(sbC);
		
		ImageIcon logoIcon = new ImageIcon(AdminLog.class.getResource("../sbPromImg/starbucksLogo.png"));
		Image logoImg = logoIcon.getImage();
		
		Image updateLogo = logoImg.getScaledInstance(screenHeight/11, screenHeight/11, Image.SCALE_SMOOTH);
		
		logoIcon = new ImageIcon(updateLogo);
		
		logoLabel.setIcon(logoIcon);
//		logoLabel.setBounds(screenWidth/5, screenHeight, screenHeight/10, screenHeight/10);
		logoLabel.setPreferredSize(new Dimension(screenHeight/11, screenHeight/11));
//		logoLabel.setHorizontalAlignment(JLabel.CENTER);
	
		
		
		
		pwField.setFont(font);
		pwArea.setFont(font);
		pwArea.setHorizontalAlignment(JLabel.CENTER);
		login.setFont(font);
		login.setOpaque(true);
		login.setBackground(sbC);
		login.setForeground(Color.white);
		login.addActionListener(this);
		pwArea.setSize((screenWidth*2)/6, screenHeight/10);
		pwArea.setBackground(sbC);
		pwArea.setOpaque(true);
		pwArea.setForeground(Color.white);
		pwField.setSize((screenWidth*2)/6, screenHeight/10);
		
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(logoLabel);
		add(topPanel,BorderLayout.NORTH);
		add(pwArea);
		add(pwField);
		add(login);
	
		
		dispose();
		setVisible(true);
	}

	public String getAdminPw() {
		return adminPw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());

		if(e.getActionCommand().equals("Login")) {
			boolean flag=true;

			if(getAdminPw().length()!=pwField.getPassword().length) {
				flag=false;
			}
			if(flag) {
				for (int i = 0; i < pwField.getPassword().length; i++) {
					if(pwField.getPassword()[i]!=getAdminPw().charAt(i)) {
						flag=false;
					}
				}				
			}
			if(flag) {
				new SalesView().startSalesView();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.\n다시 입력 해주세요.");
			}
		}
	}
	
	
	public static void main(String[] args) {
		new AdminLog().startAdminLog();
	}



}
