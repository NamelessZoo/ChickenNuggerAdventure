import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Bars extends JComponent
{
	private static int hp, ketchup;
	
	private Rectangle hpBar, ketchupBar;
	
	public Bars()
	{
		setLocation(600,600);
		setSize(120,40);
		
		hp = 100;
		ketchup = 0;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle background = new Rectangle(0,0,120,40);
		g2.setColor(Color.BLACK);
		g2.fill(background);
		
		hpBar = new Rectangle(10,10,getHP(),10);
		g2.setColor(Color.GREEN);
		g2.fill(hpBar);
		
		ketchupBar = new Rectangle(10,20,getSP(),10);
		g2.setColor(Color.RED);
		g2.fill(ketchupBar);
	}
	
	public static int getHP()
	{
		return hp;
	}
	
	public static int getSP()
	{
		return ketchup;
	}
	
	public static void setHP(int h)
	{
		hp = h;
	}
	
	public static void setSP(int s)
	{
		ketchup = s;
	}
	
	
}
