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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Flow;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import DAO.Products;

public class OrderView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//���̴� ������� 2/3 
	//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	//ž�г�
	JPanel topPanel;
	//�̵��г�
	JPanel middlePanel;
	
	
	Color sbC = new Color(1,98,65);
	
	//Products �ҷ�����
	ArrayList<JButton> buttonArray = new ArrayList<>();
	
	
	public static Products products = new Products();
	//�ӽ� ������
	public OrderView() {
		// TODO Auto-generated constructor stub
	}
	
	public void startOrderView() {
		setTitle("��Ÿ������ ���Ű��� ȯ���մϴ�");
		setSize(screenWidth,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		//ž �г� ����
		topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(sbC);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		//ž �гμ� ���� �г� -��ư��

		JButton categoriBtn1 = topMenuPanel("Ŀ��");
		categoriBtn1.setBackground(Color.white);
		categoriBtn1.setForeground(sbC);
		JButton categoriBtn2 = topMenuPanel("����");
		JButton categoriBtn3 = topMenuPanel("Ǫ��");
		
		//ž - Ȩ��ư �г���ġ
		JPanel leftPanel4 = new JPanel();
		leftPanel4.setPreferredSize(new Dimension(screenWidth*3/7,screenHeight/10));
		// Ȩ��ư 
		leftPanel4.setBackground(sbC);
		Image imgHome = new ImageIcon("src/sbPromImg/homeBtn2.png").getImage(); 
		imgHome = imgHome.getScaledInstance(screenWidth/10, screenWidth/10, Image.SCALE_SMOOTH);
		JButton homeBtn = new JButton(new ImageIcon(imgHome));
		
		homeBtn.setPreferredSize(new Dimension(screenWidth/10,screenWidth/10));
		homeBtn.setBackground(sbC);
		homeBtn.setBorderPainted(false);
		leftPanel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		leftPanel4.add(homeBtn);
		
		topPanel.add(leftPanel4);
		
		
		
		//�̵� �г� ����
		middlePanel = new JPanel();
		middlePanel.setPreferredSize(new Dimension(screenWidth,(screenHeight*6)/7));
		middlePanel.setVisible(true);
		middlePanel.setBackground(sbC);
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		JScrollPane middleScroll = new JScrollPane(middlePanel,
				  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.
				  HORIZONTAL_SCROLLBAR_NEVER);
		middleScroll.setPreferredSize(new Dimension(screenWidth,(screenHeight*5)/10));
		
		
		// ��ũ�� �ӵ� ����
		middleScroll.getVerticalScrollBar().setUnitIncrement(16);
		
		//��� �г� �̹��� \ - makeMenuButton
		//https://laonatti.tistory.com/196
				//�ֺ����ֱ�
				//buttonTest.setBorderPainted(false);
				
		/* �̹��� ��ư ������ - makeMenuButton �ż���� ����
		 * Image img = new ImageIcon("src/Imgs/1-01.png").getImage(); img =
		 * img.getScaledInstance(screenWidth/2, screenWidth/6, Image.SCALE_SMOOTH);
		 * JButton buttonTest = new JButton(new ImageIcon(img));
		 * buttonTest.setPreferredSize(new Dimension(screenWidth/2,screenWidth/6));
		 * middlePanel.add(buttonTest);
		 */
		
		makeMenuButton(null);
		
		
		
		middleScroll.setViewportView(middlePanel);
		add(middleScroll,BorderLayout.CENTER);
		
		//���� �г� ����
		JPanel bottomPanel = makePanel(screenWidth,screenHeight*3/10,BorderLayout.SOUTH);
		
		JPanel bottomInner1 = new JPanel(new BorderLayout());
		bottomInner1.setPreferredSize(new Dimension(screenWidth*2/3,screenHeight*3/10));
		bottomInner1.setBackground(sbC);
		
		JLabel orderList = new JLabel("  Order List");
		orderList.setForeground(Color.white);
		bottomInner1.add(orderList);
		JScrollPane orderPane = new JScrollPane();
		JTextArea orderArea = new JTextArea();
		orderArea.setEditable(false);
		orderArea.setBackground(Color.cyan);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		//orderArea.setPreferredSize(new Dimension(screenWidth*2/3,screenHeight*3/10));
		orderPane.setViewportView(orderArea);
		orderPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		orderPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		orderPane.setPreferredSize(new Dimension(screenWidth*2/3,screenHeight*5/20));
		bottomInner1.add(orderPane,BorderLayout.SOUTH);
		bottomPanel.add(bottomInner1);
		
		//���� ��ư , ���� ��ư
		JPanel bottomInner2 = new JPanel(new BorderLayout());
		JButton removeList = new JButton("����");
		removeList.setPreferredSize(new Dimension(screenWidth*1/3,screenHeight*1/20));
		bottomInner2.setPreferredSize(new Dimension(screenWidth*9/30,screenHeight*3/10));
		bottomInner2.add(removeList,BorderLayout.NORTH);
		JButton orderBtn = new JButton("�ֹ��ϱ�");
		bottomInner2.add(orderBtn);
		bottomPanel.add(bottomInner2);	
		
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
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
	
	//ž �г� ī�װ� ��ư ����� 
	public JButton topMenuPanel(String btnName) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(screenWidth/6,screenHeight/10));
		panel.setLayout(new BorderLayout());
		panel.setBackground(sbC);
		JButton button = new JButton(btnName);
		button.setBackground(sbC);
		button.setBorderPainted(false);
		button.setForeground(Color.white);
		panel.add(button,BorderLayout.SOUTH);
		topPanel.add(panel);
		
		return button;
	}
	
	
	//�޴� ��ư ����� �ż���
	public void makeMenuButton(String category) {
		
		for(Map.Entry<String, String> product : products.getProductImage().entrySet()) {
			Image img = new ImageIcon(product.getValue()).getImage();
			img = img.getScaledInstance(screenWidth/2*13/14, screenWidth/6*13/14, Image.SCALE_SMOOTH);
			JButton jButton = new JButton(new ImageIcon(img));	
			jButton.setPreferredSize(new Dimension(screenWidth/2*13/14,screenWidth/6*13/14));
			middlePanel.add(jButton);
			buttonArray.add(jButton);
			System.out.println(product.getKey()+" "+product.getValue());
		}
	}
	
	
	public static void main(String[] args) {
		new OrderView().startOrderView();
		System.out.println(products.getPrice("test1"));
	}
}
