package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SalesView extends JFrame implements ActionListener{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//���̴� ������� 2/3 
	//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	Color sbC = new Color(1,98,65);
	Font font = new Font("Courier",Font.BOLD,screenWidth/30);
	JPanel topPanel;
	String salesName;
	JPanel middlePanel;
	JTextArea salesMenu;
	JScrollPane salesMenuScroll;

	
	public SalesView() {};
	
	public void startSalesView() {
		
		setTitle("��Ÿ���� ������� ������");
		setSize(screenWidth,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(sbC);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		JButton coffeeBtn = topSalesBtn("Ŀ�� ����");
		JButton drinkBtn = topSalesBtn("���� ����");
		JButton foodBtn = topSalesBtn("���� ����");
		
		//ž - Ȩ��ư �г���ġ
		JPanel leftPanel4 = new JPanel();
		leftPanel4.setPreferredSize(new Dimension(screenWidth/5,screenHeight/12));
		// Ȩ��ư 
		leftPanel4.setBackground(sbC);
		Image imgHome = new ImageIcon("src/sbPromImg/homeBtn2.png").getImage(); 
		imgHome = imgHome.getScaledInstance(screenWidth/10, screenWidth/10, Image.SCALE_SMOOTH);
		JButton homeBtn = new JButton(new ImageIcon(imgHome));
		
		homeBtn.setPreferredSize(new Dimension(screenWidth/10,screenWidth/10));
		homeBtn.setBackground(sbC);
		homeBtn.setBorderPainted(false);
		homeBtn.addActionListener(this);
		homeBtn.setActionCommand("home");
		leftPanel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		leftPanel4.add(homeBtn);
		
		topPanel.add(leftPanel4);
		
		// �̵� - ���� �׷��� ǥ�ð���
		middlePanel = new JPanel();
		middlePanel.setPreferredSize(new Dimension(screenWidth,(screenHeight*5)/7));
		middlePanel.setVisible(true);
		middlePanel.setBackground(Color.white);
		

		// ���� - textArea. �޴� �̸�/����/�Ǹż���/���Ǹż��� ǥ��
		// ���� - ���� ��¥ / �� ���� ǥ��
		// ���� �󺧷� ǥ��. ������ 3:1 ����
		JPanel bottomPanel = makePanel(screenWidth,screenHeight*3/10,BorderLayout.SOUTH);
		bottomPanel.setBackground(sbC);
		salesMenu = new JTextArea(screenWidth,(screenHeight*3/10)*3/4);
		salesMenuScroll = new JScrollPane(salesMenu);


		

		
		add(middlePanel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public JPanel makePanel(int witdh,int height,String position) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(witdh,height));
		panel.setVisible(true);
		add(panel,position);
		return panel;
	}
	
	public JButton topSalesBtn(String btnName) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(screenWidth/4,screenHeight/10));
		panel.setLayout(new BorderLayout());
		panel.setBackground(sbC);
		JButton button = new JButton(btnName);
		button.setFont(font);
		button.setBackground(sbC);
		button.setBorderPainted(false);
		button.setForeground(Color.white);
		button.setFocusPainted(false);
		button.addActionListener(this);
		panel.add(button,BorderLayout.SOUTH);
		topPanel.add(panel);
		
		return button;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("home")) {
			new MainView().frameTest();
			dispose();
		}
		
	}
	
	public static void main(String[] args) {
		new SalesView().startSalesView();
	}


}
