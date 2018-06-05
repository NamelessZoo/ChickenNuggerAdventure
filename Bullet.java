import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.*;

public class Bullet extends JComponent
{
	private int dx = 10;
	
	private Ellipse2D ball;
	private Rectangle2D size;
	
	private ArrayList<Character> target;
	
	public Bullet(int x, int y)
	{
		setLocation(x,y);
		setSize(20,20);
		target = new ArrayList<Character>();
		size = new Rectangle2D.Double(getX(), getY(), 10, 5);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		ball = new Ellipse2D.Double(0,0,10,5);
		g2.setColor(Color.RED);
		g2.fill(ball);
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public Rectangle2D getRect()
	{
		return size;
	}
	
	public void damage(Character a)
	{
		target.add(a);
		new Thread(new damage()).start();
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY());
		size = new Rectangle2D.Double(getX(), getY(), 10, 5);
	}
	
	public class damage implements Runnable
	{
		public void run()
		{
			try 
			{
				if (ball != null)
				{
					for (int i = 0; i < target.size(); i++)
					{
						if(getRect().intersects(target.get(i).getRect()))
						{
							target.get(i).setDX(2);
							Thread.sleep(250);
							target.get(i).setHP(target.get(i).getHP() - 10);
						}
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
