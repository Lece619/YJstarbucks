package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
		setBounds(200,100,screenWidth+16,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		JPanel middlePanel = makePanel(screenWidth+16,screenHeight*5/10,BorderLayout.CENTER);
		JPanel bottomPanel = makePanel(screenWidth,screenHeight*3/10,BorderLayout.SOUTH);
		middlePanel.setBackground(Color.black);
		topPanel.setBackground(Color.blue);
		//가운데 패널 그리드 구성
		/*
		 * JScrollPane middleScroll = new JScrollPane(middlePanel,
		 * JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.
		 * HORIZONTAL_SCROLLBAR_NEVER); add(middleScroll,BorderLayout.CENTER);
		 * middleScroll.setVisible(true);
		 */
		//middlePanel.setLayout(new GridLayout(2,0));
		
		//이미지 버튼 테스트
		Image img = new ImageIcon("src/Imgs/1-01.png").getImage();
		img = img.getScaledInstance(screenWidth/2, screenWidth/6, Image.SCALE_SMOOTH);
		
		//middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//middlePanel.setLayout(new FlowLayout());
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton buttonTest = new JButton(new ImageIcon(img));
		buttonTest.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest);
		buttonTest.setMargin(new Insets(0, 0, 0, 0));
		
		JButton buttonTest2 = new JButton(new ImageIcon(img));
		buttonTest2.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest2);
		buttonTest2.setMargin(new Insets(0, 0, 0, 0));
		
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
