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

public class RoundedButton extends JButton{
	public RoundedButton() {super(); decorate();}
	public RoundedButton(String text) {super(text); decorate();}
	public RoundedButton(Action action) {super(action); decorate();}
	public RoundedButton(Icon icon) {super(icon); decorate();}
	public RoundedButton(String text,Icon icon) {super(text,icon); decorate();}
	protected void decorate() {setBorderPainted(false); setOpaque(false);}
	
	@Override
	protected void paintComponent(Graphics g) {
		Color bgC = new Color(255,247,242); //버튼 배경색 결정
		Color fnC = new Color(247,99,12); // 버튼 글자색 결정
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
		graphics.fillRoundRect(0, 0, width, height, 10, 10);
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
