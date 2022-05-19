package View;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton2 extends JButton{
	public RoundedButton2() {super(); decorate();}
	public RoundedButton2(String text) {super(text); decorate();}
	public RoundedButton2(Action action) {super(action); decorate();}
	public RoundedButton2(Icon icon) {super(icon); decorate();}
	public RoundedButton2(String text,Icon icon) {super(text,icon); decorate();}
	protected void decorate() {setBorderPainted(false); setOpaque(false);}
	
	@Override
	protected void paintComponent(Graphics g) {
		Color bgC = new Color(1,98,65); //버튼 배경색 결정 (짙은녹색)
		Color fnC = new Color(255,247,242); // 버튼 글자색 결정 (흰색)
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(getModel().isArmed()) {
			graphics.setColor(bgC.darker());
		}else if(getModel().isRollover()) {
			graphics.setColor(bgC.brighter());
		}else {
			graphics.setColor(bgC);
		}
		graphics.fillRoundRect(0, 0, width, height, 100, 100);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width-stringBounds.width) /2;
		int textY = (height - stringBounds.height)/2 + fontMetrics.getAscent();
		graphics.setColor(fnC);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		
		super.paintComponent(g);
	}
	

}
