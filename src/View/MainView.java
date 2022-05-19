package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//���̴� ������� 2/3 
//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	JLabel imgLabel = new JLabel();
	JPanel btnP = new JPanel();	
	
//	JButton start = new JButton("����");
//	JButton sales= new JButton("����");
	RoundedButton start = new RoundedButton("����");
	RoundedButton sales = new RoundedButton("����");
	
//	GridLayout gl = new GridLayout(1, 2);
	FlowLayout fl = new FlowLayout();

	public MainView() {
	}
	
	public void frameTest() {
		setTitle("��Ÿ������ ���Ű��� ȯ���մϴ�");
		setBounds(200,100,screenWidth,screenHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Y : MainView ��� �̹��� ����
		ImageIcon icon = new ImageIcon(
				MainView.class.getResource("../sbPromImg/starbucks.png")
			);
		Image img = icon.getImage();
		
		// Y : MainView ũ�⿡ �°� �̹��� ���� ����
		Image updateImg = img.getScaledInstance(screenWidth, (screenHeight*5)/6, Image.SCALE_SMOOTH);
		icon = new ImageIcon(updateImg);		
		
		imgLabel.setIcon(icon);
		imgLabel.setPreferredSize(new Dimension(screenWidth, screenHeight/6*5));
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// ��ư ������ ���ϱ�
		start.setPreferredSize(new Dimension(screenWidth/2, screenHeight/6));
//		start.setBorderPainted(false);
		start.setBackground(Color.white);
		sales.setPreferredSize(new Dimension(screenWidth/2, screenHeight/6));
//		sales.setBorderPainted(false);
		sales.setBackground(Color.white);
		
		// ��ư �׸��巹�̾ƿ����� ��ġ
		btnP.setBackground(Color.black);
		
//		btnP.setLayout(gl);
//		btnP.setLayout(null);
		btnP.add(start);
		btnP.add(sales);

		// MainView�� �̹�����,��ư �߰�
		getContentPane().add(imgLabel);
		add(btnP,BorderLayout.SOUTH);

		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainView().frameTest();
	}
}