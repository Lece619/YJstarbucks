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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import DAO.Products;

public class OrderView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//높이는 모니터의 2/3 
	//넓이는 높이에 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	//미들패널
	JPanel middlePanel;
	
	Color sbC = new Color(1,98,65);
	
	//Products 불러오기
	ArrayList<JButton> buttonArray = new ArrayList<>();
	
	
	public static Products products = new Products();
	//임시 생성자
	public OrderView() {
		// TODO Auto-generated constructor stub
	}
	
	public void startOrderView() {
		setTitle("스타벅스에 오신것을 환영합니다");
		setSize(screenWidth,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		//탑 패널 구성
		JPanel topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(sbC);
		
		//미들 패널 구성
		middlePanel = new JPanel();
		middlePanel.setPreferredSize(new Dimension(screenWidth,(screenHeight*6)/7));
		middlePanel.setVisible(true);
		middlePanel.setBackground(sbC);
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		JScrollPane middleScroll = new JScrollPane(middlePanel,
				  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.
				  HORIZONTAL_SCROLLBAR_NEVER);
		middleScroll.setPreferredSize(new Dimension(screenWidth,(screenHeight*5)/10));
		
		
		// 스크롤 속도 설정
		middleScroll.getVerticalScrollBar().setUnitIncrement(16);
		
		//가운데 패널 이미지 \ - makeMenuButton
		//https://laonatti.tistory.com/196
				//주변없애기
				//buttonTest.setBorderPainted(false);
				
		/* 이미지 버튼 구성단 - makeMenuButton 매서드로 구현
		 * Image img = new ImageIcon("src/Imgs/1-01.png").getImage(); img =
		 * img.getScaledInstance(screenWidth/2, screenWidth/6, Image.SCALE_SMOOTH);
		 * JButton buttonTest = new JButton(new ImageIcon(img));
		 * buttonTest.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		 * middlePanel.add(buttonTest);
		 */
		
		makeMenuButton(null);
		
		
		
		middleScroll.setViewportView(middlePanel);
		add(middleScroll,BorderLayout.CENTER);
		
		//바텀 패널 구성
		JPanel bottomPanel = makePanel(screenWidth,screenHeight*3/10,BorderLayout.SOUTH);
		
	
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setVisible(true);
	}
	
	//구성 패널 만들기
	public JPanel makePanel(int witdh,int height,String position) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(witdh,height));
		panel.setVisible(true);
		add(panel,position);
		return panel;
	}
	
	//메뉴 버튼 만들기 매서드
	public void makeMenuButton(String category) {
		for(Map.Entry<String, String> product : products.getProductImage().entrySet()) {
			Image img = new ImageIcon(product.getValue()).getImage();
			img = img.getScaledInstance(screenWidth/2*13/14, screenWidth/6*13/14, Image.SCALE_SMOOTH);
			JButton jButton = new JButton(new ImageIcon(img));	
			jButton.setPreferredSize(new Dimension(screenWidth/2*13/14,screenWidth/6*13/14));
			middlePanel.add(jButton);
			buttonArray.add(jButton);					
		}
	}
	
	
	public static void main(String[] args) {
		new OrderView().startOrderView();
		System.out.println(products.getPrice("test1"));
	}
}
