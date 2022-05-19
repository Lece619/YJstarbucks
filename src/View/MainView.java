package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame implements ActionListener{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//높이는 모니터의 2/3 
//넓이는 높이에 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	JLabel imgLabel = new JLabel();
	JPanel btnP = new JPanel();	
	
//	JButton start = new JButton("실행");
//	JButton sales= new JButton("매출");
	RoundedButton start = new RoundedButton("START");
	RoundedButton sales = new RoundedButton("SALES");
	
	GridLayout gl = new GridLayout(1, 2);
	
	Color sbC = new Color(1,98,65);
	Font font = new Font("Santana-Black",Font.BOLD,50);

	public MainView() {
	}
	
	public void frameTest() {
		setTitle("스타벅스에 오신것을 환영합니다");
		setBounds(200,100,screenWidth,screenHeight);
		setResizable(false);
		setLocationRelativeTo(null);

		
		// Y : MainView 배경 이미지 지정
		ImageIcon icon = new ImageIcon(
				MainView.class.getResource("../sbPromImg/starbucks.png")
			);
		Image img = icon.getImage();
		
		// Y : MainView 크기에 맞게 이미지 비율 조절
		Image updateImg = img.getScaledInstance(screenWidth, (screenHeight*5)/6, Image.SCALE_SMOOTH);
		icon = new ImageIcon(updateImg);		
		
		imgLabel.setIcon(icon);
		imgLabel.setPreferredSize(new Dimension(screenWidth, screenHeight/6*5));
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// 버튼 사이즈 정하기
		start.setPreferredSize(new Dimension(screenWidth/2, screenHeight/6));
		start.setBackground(Color.white);
		start.setFont(font);
		start.addActionListener(this);
		sales.setPreferredSize(new Dimension(screenWidth/2, screenHeight/6));
		sales.setBackground(Color.white);
		sales.setFont(font);
		sales.addActionListener(this);
		
		// 버튼 그리드레이아웃으로 배치
		btnP.setBackground(sbC);
		btnP.setLayout(gl);
		btnP.add(start);
		btnP.add(sales);

		// MainView에 이미지라벨,버튼 추가
		getContentPane().add(imgLabel);
		add(btnP,BorderLayout.SOUTH);

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()) {
		case "START" :
			new OrderView().startOrderView();
//			dispose();
			break;
		case "SALES" :
			new SalesView().startSalesView();
//			dispose();
			break;
		}
		
	}
	
	public static void main(String[] args) {
		new MainView().frameTest();
	}

}
