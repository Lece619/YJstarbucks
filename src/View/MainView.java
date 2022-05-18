package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//���̴� ������� 2/3 
//���̴� ���̿� 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	public MainView() {
	}
	
	public void frameTest() {
		setTitle("��Ÿ������ ���Ű��� ȯ���մϴ�");
		setBounds(200,100,screenWidth,screenHeight);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainView().frameTest();
	}
}
