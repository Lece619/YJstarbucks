package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SalesView extends JFrame{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//높이는 모니터의 2/3 
	//넓이는 높이에 3/4 
	int screenHeight = (dimension.height*2)/3;
	int screenWidth = (screenHeight*3)/4;
	
	Color sbC = new Color(1,98,65);
	Font font = new Font("Impact",Font.BOLD,screenWidth/15);
	
	public SalesView() {};
	
	public void startSalesView() {
		
		setTitle("스타벅스 매출관리 페이지");
		setSize(screenWidth,screenHeight);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel topPanel= makePanel(screenWidth,screenHeight/10,BorderLayout.NORTH);
		topPanel.setBackground(sbC);
		
		
		
		
		dispose();
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
		new SalesView().startSalesView();
	}

}
