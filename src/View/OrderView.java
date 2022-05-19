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
	//���̴� ������� 2/3 
	//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
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
		JPanel topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(sbC);
		
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
	
	//�޴� ��ư ����� �ż���
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
