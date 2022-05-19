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
//���̴� ������� 2/3 
//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	JLabel imgLabel = new JLabel();
	JPanel btnP = new JPanel();	
	
//	JButton start = new JButton("����");
//	JButton sales= new JButton("����");
	RoundedButton start = new RoundedButton("START");
	RoundedButton sales = new RoundedButton("SALES");
	
	GridLayout gl = new GridLayout(1, 2);
	
	Color sbC = new Color(1,98,65);
	Font font = new Font("Santana-Black",Font.BOLD,50);

	public MainView() {
	}
	
	public void frameTest() {
		setTitle("��Ÿ������ ���Ű��� ȯ���մϴ�");
		setBounds(200,100,screenWidth,screenHeight);
		setResizable(false);
		setLocationRelativeTo(null);

		
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
		start.setBackground(Color.white);
		start.setFont(font);
		start.addActionListener(this);
		sales.setPreferredSize(new Dimension(screenWidth/2, screenHeight/6));
		sales.setBackground(Color.white);
		sales.setFont(font);
		sales.addActionListener(this);
		
		// ��ư �׸��巹�̾ƿ����� ��ġ
		btnP.setBackground(sbC);
		btnP.setLayout(gl);
		btnP.add(start);
		btnP.add(sales);

		// MainView�� �̹�����,��ư �߰�
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
