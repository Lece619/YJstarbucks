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

import DAO.Products;

public class OrderView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//���̴� ������� 2/3 
	//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	//Products �ҷ�����
	public static Products products = new Products();
	//�ӽ� ������
	public OrderView() {
		// TODO Auto-generated constructor stub
	}
	
	public void startOrderView() {
		setTitle("��Ÿ������ ���Ű��� ȯ���մϴ�");
		setBounds(200,100,screenWidth+10,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		//ž �г� ����
		JPanel topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(Color.blue);
		
		//�̵� �г� ����
//		JPanel middlePanel = makePanel(screenWidth,screenHeight*5/10,BorderLayout.CENTER);
//		middlePanel.setBackground(Color.white);
		JPanel middlePanel = new JPanel();
		middlePanel.setPreferredSize(new Dimension(screenWidth,(screenHeight*5)/10));
		middlePanel.setVisible(true);
		JScrollPane middleScroll = new JScrollPane(middlePanel,
				  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.
				  HORIZONTAL_SCROLLBAR_NEVER);
		//��� �г� �̹��� \
		Image img = new ImageIcon("src/Imgs/1-01.png").getImage();
		img = img.getScaledInstance(screenWidth/2, screenWidth/6, Image.SCALE_SMOOTH);
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));
		
		JButton buttonTest = new JButton(new ImageIcon(img));
		buttonTest.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest);
		buttonTest.setMargin(new Insets(0, 0, 0, 0));
		
		JButton buttonTest2 = new JButton(new ImageIcon(img));
//		JButton buttonTest2 = new JButton(" ");
		buttonTest2.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		middlePanel.add(buttonTest2);
		buttonTest2.setMargin(new Insets(0, 0, 0, 0));
		middleScroll.setViewportView(middlePanel);
		add(middleScroll,BorderLayout.CENTER);
		
		//���� �г� ����
		JPanel bottomPanel = makePanel(screenWidth,screenHeight*3/10,BorderLayout.SOUTH);
		
		
		
		//��� �г� �׸��� ����
		
		/*
		 * JScrollPane middleScroll = new JScrollPane(middlePanel,
		 * JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.
		 * HORIZONTAL_SCROLLBAR_NEVER); add(middleScroll,BorderLayout.CENTER);
		 * middleScroll.setVisible(true);
		 */
		//middlePanel.setLayout(new GridLayout(2,0));
		
		//�̹��� ��ư �׽�Ʈ
		
		//middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//middlePanel.setLayout(new FlowLayout());
//		middlePanel.setLayout(new GridLayout(2,0));
	
//		JButton buttonTest = new JButton("");
		
		//https://laonatti.tistory.com/196
		//�ֺ����ֱ�
		//buttonTest.setBorderPainted(false);
		
		
		
		
		
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
		System.out.println(products.getPrice("test1"));
	}
}
