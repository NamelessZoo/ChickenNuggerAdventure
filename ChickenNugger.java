import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ChickenNugger extends JComponent
{
	private int dx = 0, dy = 0;
	private int damage, heal, gain;
	
	private static int x, y;
	
	private boolean superMode = false;
	private boolean jumping = false;
	private boolean left = false;
	
	private int width, height;
	
	private int frameWidth = 1000;
	private int frameHeight = 900;
	
	private BufferedImage image = null;
	
	private String chickenNugger = "CHICKENNUGGER.png";
	private String chickenNuggerPunch = "CHICKENNUGGERPUNCH.png";
	private String chickenNuggerSuper = "CHICKENNUGGERSUPER.png";
	private String chickenNuggerSuperPunch = "CHICKENNUGGERSUPERPUNCH.png";
	private String chickenNuggerLeft = "CHICKENNUGGERLEFT.png";
	private String chickenNuggerLeftPunch = "CHICKENNUGGERLEFTPUNCH.png";
	private String chickenNuggerLeftSuper = "CHICKENNUGGERLEFTSUPER.png";
	private String chickenNuggerLeftSuperPunch = "CHICKENNUGGERLEFTSUPERPUNCH.png";
	
	public ChickenNugger(int x, int y)
	{
		setLocation(x, y);
		setSize(500,500);
		try 
		{
			image = ImageIO.read(new File(chickenNugger));
			setDimensions();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 3, 4, this);
	}
	
	public void setDY(int y)
	{
		dy = y;
	}
	
	public void setDX(int x)
	{
		dx = x;
		try 
		{
			if (x > 0)
			{
				left = false;
				if (superMode)
				{
					image = ImageIO.read(new File(chickenNuggerSuper));
					setDimensions();
				}
				else
				{
					image = ImageIO.read(new File(chickenNugger));
					setDimensions();
				}
			}
			if (x < 0)
			{
				left = true;
				if (superMode)
				{
					image = ImageIO.read(new File(chickenNuggerLeftSuper));
					setDimensions();
				} 
				else
				{
					image = ImageIO.read(new File(chickenNuggerLeft));
					setDimensions();
				}
			}
		}	
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void jumping()
	{
		if (!jumping)
		{
			new Thread(new jumper()).start();
		}
	}
	
	public void superMode()
	{
		if (Bars.getSP() == 100)
		{
			new Thread(new ult()).start();
		}
	}
	
	public void punching()
	{
		new Thread(new puncher()).start();
	}
	
	public void damaged(int d)
	{
		damage = d;
		new Thread(new damage()).start();
	}
	
	public void healed(int h)
	{
		heal = h;
		new Thread(new heal()).start();
	}
	
	public void spGain(int s)
	{
		gain = s;
		new Thread(new gainSP()).start();
	}
	
	public void setDimensions()
	{
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void update()
	{
		if ((getX() <= 0 && dx < 0) || (getX() >= frameWidth && dx > 0))
			setLocation(getX(), getY() + dy);
		else
			setLocation(getX() + dx, getY() + dy);
	}
	
	public class ult implements Runnable
	{
		public void run()
		{
			try
			{
				superMode = true;
				image = ImageIO.read(new File(chickenNuggerSuper));
				setDimensions();
				for (int i = 1; i <= 100; i++)
				{
					Bars.setSP(100-i);
					Thread.sleep(100);
				}
				image = ImageIO.read(new File(chickenNugger));
				setDimensions();
				superMode = false;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
	
	public class jumper implements Runnable
	{
		public void run()
		{
			try
			{
				jumping = true;
				for(int i = -5; i <= 5; i++)
				{
					setDY(i); 
					Thread.sleep(200 - 30*Math.abs(i));
				}
				setDY(0);
				jumping = false;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
	
	public class puncher implements Runnable
	{
		public void run()
		{
			try
			{
				if (superMode && left)
				{
					image = ImageIO.read(new File(chickenNuggerLeftSuperPunch));
					setDimensions();
					Thread.sleep(200);
					image = ImageIO.read(new File(chickenNuggerLeftSuper));
					setDimensions();
				}
				else if (superMode)
				{
					image = ImageIO.read(new File(chickenNuggerSuperPunch));
					setDimensions();
					Thread.sleep(200);
					image = ImageIO.read(new File(chickenNuggerSuper));
					setDimensions();
				}
				else if (left)
				{
					image = ImageIO.read(new File(chickenNuggerLeftPunch));
					setDimensions();
					Thread.sleep(200);
					image = ImageIO.read(new File(chickenNuggerLeft));
					setDimensions();
				}
				else
				{
					image = ImageIO.read(new File(chickenNuggerPunch));
					setDimensions();
					Thread.sleep(200);
					image = ImageIO.read(new File(chickenNugger));
					setDimensions();
				}
			}
			catch (Exception e)
			{
				 e.printStackTrace();;
				 new Thread(this).start();
				 System.exit(0);
			}
		}
	}
	
	public class damage implements Runnable
	{
		public void run()
		{
			try
			{
				for (int i = 0; i < damage; i++)
				{
					Bars.setHP(Bars.getHP() - 1);
					Thread.sleep(25);
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
	
	public class heal implements Runnable
	{
		public void run()
		{
			try
			{
				for (int i = 0; i < heal; i++)
				{
					if (Bars.getHP() < 100)
					{
						Bars.setHP(Bars.getHP() + 1);
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
	
	public class gainSP implements Runnable
	{
		public void run()
		{
			try
			{
				for (int i = 0; i < gain; i++)
				{
					if (Bars.getSP() < 100)
					{
						Bars.setSP(Bars.getSP() + 1);
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


