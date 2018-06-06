import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class PotatoBullets extends JComponent
{
	private int dx = -5;
	
	private BufferedImage image;
	private Rectangle2D size;
	private ChickenNugger nugger;
	
	private boolean damaged;
	
	private String potatoBullet = "potatobullet.png";
	
	public PotatoBullets(int x, int y)
	{
		setLocation (x,y);
		setSize(500,500);
		try
		{
			image = ImageIO.read(new File(potatoBullet));
			size = new Rectangle2D.Double(getX(), getY(), image.getWidth(), image.getHeight());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void paintComponent (Graphics g)
	{
		g.drawImage(image, 0, 0, this);
	}
	
	public void update()
	{
		setLocation (getX() + dx, getY());
		size = new Rectangle2D.Double(getX(), getY(), image.getWidth(), image.getHeight());
	}
	
	public Rectangle2D getRect()
	{
		return size;
	}
	
	public boolean damage(ChickenNugger c)
	{
		nugger = c;
		new Thread(new damage()).start();
		return damaged;
	}
	
	public class damage implements Runnable
	{
		public void run()
		{
			try 
			{
				if(getRect().intersects(nugger.getRect()))
				{
					damaged = true;
					nugger.setDX(-2);
					Thread.sleep(250);
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
