import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class TutRect extends JComponent
{
	double height;
	double width; 
	
	public TutRect(double mash, double masw)
	{
		setLocation(0,0);
		setLayout(null);
		setSize((int)masw, (int)mash);
		height = mash;
		width = masw;
		setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		Rectangle ground = new Rectangle(0, (int)(2*height / 3), (int)(width), (int)(height / 3));
		g2.setColor(Color.BLACK);
		g2.fill(ground);
	}
}
