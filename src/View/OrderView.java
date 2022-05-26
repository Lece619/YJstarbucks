package View;

import java.awt.BorderLayout;
import java.awt.Color;import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import DAO.Products;

public class OrderView extends JFrame implements ActionListener{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//높이는 모니터의 2/3 
	//넓이는 높이에 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	Color sbC = new Color(1,98,65);
	//오더파일
	private File orderFile = new File("./src/order.txt");
	
	//탑패널
	JPanel topPanel;
	//탑패널 - 현재 메뉴 버튼이름
	String categoriName="커피";
	String orderMenuName="";
	JButton[] categoriBtn = new JButton[3];
	
	//미들패널
	JPanel middlePanel;
	
	
	
	//Products 불러오기
	ArrayList<JButton> btnArrayCoffee = new ArrayList<>();
	ArrayList<JButton> btnArrayDrink = new ArrayList<>();
	ArrayList<JButton> btnArrayFood = new ArrayList<>();
	
	
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
		topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(sbC);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		//탑 패널속 작은 패널 -버튼들

		categoriBtn[0] = topMenuBtn("커피");
		categoriBtn[1] = topMenuBtn("음료");
		categoriBtn[2] = topMenuBtn("푸드");
		makeColorMenuBtn(0);
		
		//탑 - 홈버튼 패널위치
		JPanel leftPanel4 = new JPanel();
		leftPanel4.setPreferredSize(new Dimension(screenWidth*3/7,screenHeight/10));
		// 홈버튼 
		leftPanel4.setBackground(sbC);
		Image imgHome = new ImageIcon("src/sbPromImg/homeBtn2.png").getImage(); 
		imgHome = imgHome.getScaledInstance(screenWidth/10, screenWidth/10, Image.SCALE_SMOOTH);
		JButton homeBtn = new JButton(new ImageIcon(imgHome));
		
		homeBtn.setPreferredSize(new Dimension(screenWidth/10,screenWidth/10));
		homeBtn.setBackground(sbC);
		homeBtn.setBorderPainted(false);
		homeBtn.setActionCommand("home");
		homeBtn.addActionListener(this);
		leftPanel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		leftPanel4.add(homeBtn);
		
		topPanel.add(leftPanel4);
		
		
		
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
		
		//가운데 패널 이미지 \ 
				//buttonTest.setBorderPainted(false);
		//public void makeMenuButton(String category) 버튼 생성 
		makeMenuButton(null);
		
		
		
		middleScroll.setViewportView(middlePanel);
		add(middleScroll,BorderLayout.CENTER);
		
		//바텀 패널 구성
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
		orderArea.append("아메리카노\t\t수량\n");
		orderArea.append("에스프레소 콘파다냐\t\t수량\n");
		orderArea.append("└옵션: \n");
		orderArea.append("==========================\n");
		orderArea.append("아메리카노\t\t\t수량\n");
		orderArea.append("에스프레소 콘파다냐\t\t수량\n");
		orderArea.append("└옵션: \n");
		orderArea.append("==========================\n");
		orderArea.append("아메리카노\t\t\t수량\n");
		orderArea.append("에스프레소 콘파다냐\t\t수량\n");
		orderArea.append("└옵션: \n");
		orderArea.append("==========================\n");
		orderArea.append("아메리카노\t\t\t수량\n");
		orderArea.append("에스프레소 콘파다냐\t\t수량\n");
		orderArea.append("└옵션: \n");
		orderArea.append("==========================\n");
		orderArea.setBackground(Color.cyan);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		//orderArea.setPreferredSize(new Dimension(screenWidth*2/3,screenHeight*3/10));
		orderPane.setViewportView(orderArea);
		orderPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		orderPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		orderPane.setPreferredSize(new Dimension(screenWidth*2/3,screenHeight*5/20));
		bottomInner1.add(orderPane,BorderLayout.SOUTH);
		bottomPanel.add(bottomInner1);
		
		//비우기 버튼 , 결제 버튼
		JPanel bottomInner2 = new JPanel(new BorderLayout());
		JButton removeList = new JButton("비우기");
		removeList.setPreferredSize(new Dimension(screenWidth*1/3,screenHeight*1/20));
		bottomInner2.setPreferredSize(new Dimension(screenWidth*9/30,screenHeight*3/10));
		bottomInner2.add(removeList,BorderLayout.NORTH);
		JButton orderBtn = new JButton("주문하기");
		bottomInner2.add(orderBtn);
		bottomPanel.add(bottomInner2);	
		
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	
	//탑 패널 카테고리 버튼 만들기 
	public JButton topMenuBtn(String btnName) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(screenWidth/6,screenHeight/10));
		panel.setLayout(new BorderLayout());
		panel.setBackground(sbC);
		JButton button = new JButton(btnName);
		button.addActionListener(this);
		button.setBackground(sbC);
		button.setBorderPainted(false);
		button.setForeground(Color.white);
		panel.add(button,BorderLayout.SOUTH);
		topPanel.add(panel);
		
		return button;
	}
	
	
	//메뉴 버튼 만들기 매서드
	public void makeMenuButton(String category) {
		
		
		for(Map.Entry<String, String> product : products.getProductImage().entrySet()) {
			Image img = new ImageIcon(product.getValue()).getImage();
			img = img.getScaledInstance(screenWidth/2*13/14, screenWidth/6*13/14, Image.SCALE_SMOOTH);
			JButton jButton = new JButton(new ImageIcon(img));	
			jButton.setPreferredSize(new Dimension(screenWidth/2*13/14,screenWidth/6*13/14));
			jButton.addActionListener(this);
			jButton.setActionCommand(product.getKey());
			//한글 테스트
			//jButton.setActionCommand("한글테스트");
			
			if(products.getCategori(product.getKey()).equals("coffee")) {
				middlePanel.add(jButton);
				btnArrayCoffee.add(jButton);
				System.out.println("버튼하나 넣음"+btnArrayCoffee.size());
			}
			else if(products.getCategori(product.getKey()).equals("drink")) {
				btnArrayDrink.add(jButton);
				jButton.setVisible(false);
				middlePanel.add(jButton);
			}else if(products.getCategori(product.getKey()).equals("food")) {
				btnArrayFood.add(jButton);
				jButton.setVisible(false);
				middlePanel.add(jButton);
			}
			
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		//키셋에 포함되어있으면 메뉴버튼
		if(products.getProductImage().keySet().contains(e.getActionCommand())) {
			//카테고리 이름별 실행
			orderMenuName=e.getActionCommand();
			if(categoriName.equals("커피"))
			System.out.println("keySet 테스트");
			else {
				System.out.println("실패");
			}
			new OptionFrame().startOptionFrame();
		}
		//카테고리별 버튼 보이기
		System.out.println("클릭버튼 :  "+e.getActionCommand());
		if(e.getActionCommand().equals("커피")) {
			makeColorMenuBtn(0);
			int cnt=1;
			for (JButton jButton : btnArrayCoffee) {
				jButton.setVisible(true);
				System.out.println(jButton.getActionCommand()+" "+(cnt++));
			}for (JButton jButton : btnArrayDrink) {
				jButton.setVisible(false);
			}
			for (JButton jButton : btnArrayFood) {
				jButton.setVisible(false);
				middlePanel.add(jButton);
			}
			middlePanel.repaint();
		}else if(e.getActionCommand().equals("음료")) {
			makeColorMenuBtn(1);
			for (JButton jButton : btnArrayCoffee) {
				jButton.setVisible(false);
			}
			for (JButton jButton : btnArrayDrink) {
				jButton.setVisible(true);
			}
			for (JButton jButton : btnArrayFood) {
				jButton.setVisible(false);
				middlePanel.add(jButton);
			}
			middlePanel.repaint();
		}else if(e.getActionCommand().equals("푸드")) {
			makeColorMenuBtn(2);
			for (JButton jButton : btnArrayCoffee) {
				jButton.setVisible(false);
			}for (JButton jButton : btnArrayDrink) {
				jButton.setVisible(false);
			}
			for (JButton jButton : btnArrayFood) {
				jButton.setVisible(true);
				middlePanel.add(jButton);
			}
			middlePanel.repaint();
		}
		
		
		switch(e.getActionCommand()) {
			case  "home" :
				new MainView().frameTest();
				dispose();
				break;
			
		}
		
	}
	
	//카테고리 별 색 넣기
	public void makeColorMenuBtn(int i) {
		categoriBtn[i%3].setBackground(Color.white);
		categoriBtn[i%3].setForeground(sbC);
		categoriBtn[(i+1)%3].setBackground(sbC);
		categoriBtn[(i+1)%3].setForeground(Color.white);
		categoriBtn[(i+2)%3].setBackground(sbC);
		categoriBtn[(i+2)%3].setForeground(Color.white);
		categoriName = categoriBtn[i].getActionCommand();
	}
	//옵션 창 inner클래스
	class OptionFrame extends JFrame {
		JRadioButton[] option_size = new JRadioButton[3];
		JRadioButton[] option_cup = new JRadioButton[3];
		JRadioButton[] option_hotIce=new JRadioButton[2];
		int cnt = 1;
		JLabel numLabel = new JLabel(cnt+"");
		
		public OptionFrame() {
		}
		
		
		public void chooseIce() {
			JPanel jPanel = new JPanel(new GridLayout(0,1));

			jPanel.setBorder(new LineBorder(Color.black,1));
			JLabel label  = new JLabel(" Hot & Ice");
			JPanel jPanel2 = new JPanel(new GridLayout(1,0));
			option_hotIce[0] =new JRadioButton("Hot");
			option_hotIce[1] =new JRadioButton("Ice");
			ButtonGroup group = new ButtonGroup();
			group.add(option_hotIce[0]);
			group.add(option_hotIce[1]);
			jPanel.add(label);
			jPanel2.add(option_hotIce[0]);
			jPanel2.add(option_hotIce[1]);
			jPanel.add(jPanel2);
			add(jPanel);
		}
		
		public void chooseSize() {
			JPanel jPanel = new JPanel(new GridLayout(0,1));
			jPanel.setBorder(new LineBorder(Color.black,1));
			JLabel label  = new JLabel(" 사이즈 선택");
			JPanel jPanel2 = new JPanel(new GridLayout(2,0));
			option_size[0] =new JRadioButton("Tall");
			option_size[1] =new JRadioButton("Grande");
			option_size[2] =new JRadioButton("Venti");
			JLabel optionFee = new JLabel("");
			JLabel optionFee1 = new JLabel("(+ 500원)");
			JLabel optionFee2 = new JLabel("(+ 1,000원)");
			ButtonGroup group = new ButtonGroup();
			group.add(option_size[0]);
			group.add(option_size[1]);
			group.add(option_size[2]);
			jPanel.add(label);
			jPanel2.add(option_size[0]);
			jPanel2.add(option_size[1]);
			jPanel2.add(option_size[2]);
			jPanel2.add(optionFee);
			jPanel2.add(optionFee1);
			jPanel2.add(optionFee2);
			jPanel.add(jPanel2);
			add(jPanel);
		}
		
		public void chooseCup() {
			JPanel jPanel = new JPanel(new GridLayout(0,1));

			jPanel.setBorder(new LineBorder(Color.black,1));
			JLabel label  = new JLabel(" 컵 선택");
			JPanel jPanel2 = new JPanel(new GridLayout(1,0));
			option_cup[0] =new JRadioButton("매장컵");
			option_cup[1] =new JRadioButton("개인컵");
			option_cup[2] =new JRadioButton("일회용컵");
			ButtonGroup group = new ButtonGroup();
			group.add(option_cup[0]);
			group.add(option_cup[1]);
			group.add(option_cup[2]);
			jPanel.add(label);
			jPanel2.add(option_cup[0]);
			jPanel2.add(option_cup[1]);
			jPanel2.add(option_cup[2]);
			jPanel.add(jPanel2);
			add(jPanel);
		}
		
		public void inputOrderPanel() {
			JPanel jPanel = new JPanel(new GridLayout(0,1));

			jPanel.setBorder(new LineBorder(Color.black,1));
			JPanel cntPanel = new JPanel(new GridLayout(1,0));
			
			JButton plusBtn = new JButton("+");
			JButton minusBtn = new JButton("-");
			plusBtn.setBackground(Color.white);
			minusBtn.setBackground(Color.white);
			JLabel label = new JLabel("수량 :");
			cntPanel.add(plusBtn);
			cntPanel.add(minusBtn);
			cntPanel.add(label);
			cntPanel.add(numLabel);
			
			JPanel orderPanel = new JPanel(new GridLayout(1,0));
			JButton cancel = new JButton("취소");
			JButton addOrder = new JButton("담기");
			orderPanel.add(cancel);
			orderPanel.add(addOrder);
			jPanel.add(cntPanel);
			jPanel.add(orderPanel);
			add(jPanel);
		}
		
		public void startOptionFrame() {
			setTitle("옵션을 선택해 주세요");
			
			setResizable(false);
			setLayout(new GridLayout(0,1));
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			JPanel optionNamePanel = new JPanel(new GridLayout(0,1));
			
			JLabel optionLabel = new JLabel(" Choose Option");
			optionNamePanel.setBorder(new LineBorder(Color.black,3));
			optionLabel.setBackground(sbC);
			optionLabel.setForeground(Color.white);
			optionLabel.setVisible(true);
			optionNamePanel.add(optionLabel);
			optionNamePanel.setBackground(sbC);
			JLabel optionLabel2 = new JLabel(" "+orderMenuName);
			optionLabel2.setBackground(sbC);
			optionLabel2.setForeground(Color.white);
			optionLabel2.setVisible(true);
			optionNamePanel.add(optionLabel2);
			
			if(categoriName.equals("커피")) {
				setSize(screenWidth*3/5,screenHeight*3/4);
				add(optionNamePanel);
				chooseIce();
				chooseSize();
				chooseCup();
				inputOrderPanel();
				//putInBtn();
			}else if(categoriName.equals("음료")){
				setSize(screenWidth*3/5,screenHeight*3/4*4/5);
				add(optionNamePanel);
				chooseSize();
				chooseCup();
				inputOrderPanel();
			}else {
				setSize(screenWidth*3/5,screenHeight*3/4*2/5);
				add(optionNamePanel);
				inputOrderPanel();
			}
			setLocationRelativeTo(null);
			
			
			//수량 담기버튼
			JPanel radioPanel4 = new JPanel(new FlowLayout());
			JLabel radioOption4 = new JLabel("사이즈2");
			radioPanel4.setBackground(Color.gray);
			radioPanel4.setSize(new Dimension(screenWidth/3,screenHeight/12));
			radioOption4.setPreferredSize(new Dimension(screenWidth/3,screenHeight/12));
			radioPanel4.add(radioOption4);
			
			JRadioButton test =new JRadioButton("선택");
		//	add(test);
			
			setVisible(true);
			
		}
	}
	
	
	public static void main(String[] args) {
		new OrderView().startOrderView();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(calendar.getTime()));
	}
}




