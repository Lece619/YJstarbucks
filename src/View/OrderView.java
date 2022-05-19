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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import DAO.Products;

public class OrderView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//���̴� ������� 2/3 
	//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	//Products �ҷ�����
	ArrayList<JButton> buttonArray = new ArrayList<>();
	
	
	public static Products products = new Products();
	//�ӽ� ������
	public OrderView() {
		// TODO Auto-generated constructor stub
	}
	
	public void startOrderView() {
		setTitle("��Ÿ������ ���Ű��� ȯ���մϴ�");
		setBounds(200,100,screenWidth,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		//ž �г� ����
		JPanel topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(Color.blue);
		
		//�̵� �г� ����
		JPanel middlePanel = new JPanel();
		middlePanel.setPreferredSize(new Dimension(screenWidth,(screenHeight*5)/10));
		middlePanel.setVisible(true);
		JScrollPane middleScroll = new JScrollPane(middlePanel,
				  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.
				  HORIZONTAL_SCROLLBAR_NEVER);
		
		//��� �г� �̹��� \ - makeMenuButton
		//https://laonatti.tistory.com/196
				//�ֺ����ֱ�
				//buttonTest.setBorderPainted(false);
				
		Image img = new ImageIcon("src/Imgs/1-01.png").getImage();
		img = img.getScaledInstance(screenWidth/2, screenWidth/6, Image.SCALE_SMOOTH);
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));
		
		JButton buttonTest = new JButton(new ImageIcon(img));
		
		buttonTest.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest);
		
		JButton buttonTest2 = new JButton(new ImageIcon(img));
		buttonTest2.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest2);
		JButton buttonTest3 = new JButton(new ImageIcon(img));
		buttonTest3.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest3);
		JButton buttonTest4 = new JButton(new ImageIcon(img));
		buttonTest4.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest4);
		JButton buttonTest5 = new JButton(new ImageIcon(img));
		buttonTest5.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest5);
		JButton buttonTest6 = new JButton(new ImageIcon(img));
		buttonTest6.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest6);
		JButton buttonTest7 = new JButton(new ImageIcon(img));
		buttonTest7.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest7);
		Image imgTest3 = new ImageIcon(products.getImg("test3")).getImage();
		imgTest3 = imgTest3.getScaledInstance(screenWidth/2, screenWidth/6, Image.SCALE_SMOOTH);
		System.out.println("�̹��� ���" + products.getImg("test3"));
		JButton buttonTest8 = new JButton(new ImageIcon(imgTest3));
		buttonTest8.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest8);
		
		
		
		middleScroll.setViewportView(middlePanel);
		add(middleScroll,BorderLayout.CENTER);
		
		//���� �г� ����
		JPanel bottomPanel = makePanel(screenWidth,screenHeight*3/10,BorderLayout.SOUTH);
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//���� �г� �����
	public JPanel makePanel(int witdh,int height,String position) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(witdh,height));
		panel.setVisible(true);
		add(panel,position);
		return panel;
	}
	
	public void makeMenuButton(String category) {
		
	}
	
	
	public static void main(String[] args) {
		new OrderView().startOrderView();
		System.out.println(products.getPrice("test1"));
	}
}
