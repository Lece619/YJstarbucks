package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//높이는 모니터의 2/3 
	//넓이는 높이에 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	//임시 생성자
	public OrderView() {
		// TODO Auto-generated constructor stub
	}
	
	public void startOrderView() {
		setTitle("스타벅스에 오신것을 환영합니다");
		setBounds(200,100,screenWidth,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel topPanel= makePanel(screenWidth,screenHeight/5,BorderLayout.NORTH);
		JPanel middlePanel = makePanel(screenWidth,screenHeight*3/5,BorderLayout.CENTER);
		JPanel bottomPanel = makePanel(screenHeight,screenHeight/5,BorderLayout.SOUTH);
		middlePanel.setBackground(Color.black);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		new OrderView().startOrderView();
	}
}
