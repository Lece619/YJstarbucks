package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class AdminLog extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	private String adminPw = "1234";
	
	JPanel middlePanel;
	
	Color sbC = new Color(1,98,65);
	Font font = new Font("Santana-Black",Font.BOLD,50);
	
	JPasswordField pwField;
	JButton login = new JButton("Login");
	JLabel pwArea = new JLabel("비밀번호 입력");
	
	
	public AdminLog() {};
	
	public void startAdminLog() {
		setTitle("스타벅스 관리자 로그인 페이지");
		setSize((screenWidth*2)/3,screenHeight/2);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel pwPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		pwPanel.setBackground(sbC);		
		
		pwArea.setFont(font);
		pwArea.setPreferredSize(new Dimension(screenWidth/2,screenHeight));
		
		add(pwArea);
//		add(pwField);
//		middlePanel.add(pwField);
		
		
		
		
		
		dispose();
		setVisible(true);
	}
	
	public JPanel makePanel(int witdh,int height,String position) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(witdh,height));
		panel.setVisible(true);
		add(panel,position);
		return panel;
	}
	
	public static void main(String[] args) {
		new AdminLog().startAdminLog();
	}

}
