import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.*;

public class Bomb extends JComponent
{
	private int dy = 5;
	
	private Ellipse2D ball;
	private Rectangle2D size;
	
	private boolean damaged;
	
	private ChickenNugger target;
	
	public Bomb(int x, int y)
	{
		setLocation(x,y);
		setSize(20,20);
		size = new Rectangle2D.Double(getX(), getY(), 20,20);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		ball = new Ellipse2D.Double(0,0,20,20);
		g2.setColor(Color.BLACK);
		g2.fill(ball);
	}
	
	public void setDY(int y)
	{
		dy = y;
	}
	
	public Rectangle2D getRect()
	{
		return size;
	}
	

	public boolean damage(ChickenNugger a)
	{
		target = a;
		new Thread(new damage()).start();
		return damaged;
	}
	
	public void update()
	{
		setLocation(getX(), getY() + dy);
		size = new Rectangle2D.Double(getX(), getY(), 20, 20);
	}
	
	
	public class damage implements Runnable
	{
		public void run()
		{
			try 
			{
				if(getRect().intersects(target.getRect()))
				{
					damaged = true;
					for (int i = 0; i < 15; i++)
					{
						Bars.setHP(Bars.getHP() - 1);
						Thread.sleep(25);
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
}
