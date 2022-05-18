package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//높이는 모니터의 2/3 
//넓이는 높이에 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	JLabel imgLabel = new JLabel();
	JPanel btnP = new JPanel();	
	
	JButton start = new JButton("실행");
	JButton sales= new JButton("매출");
	
	GridLayout gl = new GridLayout(1, 1);

	public MainView() {
	}
	
	public void frameTest() {
		setTitle("스타벅스에 오신것을 환영합니다");
		setBounds(200,100,screenWidth,screenHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		sales.setPreferredSize(new Dimension(screenWidth/2, screenHeight/6));
		
		// 버튼 그리드레이아웃으로 배치
		btnP.setLayout(gl);
		btnP.add(start);
		btnP.add(sales);

		// MainView에 이미지라벨,버튼 추가
		getContentPane().add(imgLabel);
		add(btnP,BorderLayout.SOUTH);

		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainView().frameTest();
	}
}
