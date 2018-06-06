import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class FrenchFried extends Character
{
	private BufferedImage image = null;
	private static boolean alive = false;
	
	private String fries = "frenchfried.png";
	
	public FrenchFried(int x, int y)
	{
		super(x,y);
		try
		{
			image = ImageIO.read(new File(fries));
			setSize(image);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		setHP(1000);
		alive = true;
	}
	
	public void smash()
	{
		new Thread(new smash()).start();
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 3, 4, this);
		setSize(image);
	}
	
	public void update()
	{
		if ((getX() <= 0 && getDX() < 0) || (getX() >= 1920 && getDX() > 0))
			setDX(0);
		for (int i = 0; i < Platform.getPlatforms().size(); i++)
		{
			if (getRect().intersects(Platform.getPlatforms().get(i).getRect()) && ((getDX() > 0 && getX() < Platform.getPlatforms().get(i).getRect().getX())||(getDX() < 0 && getX() > Platform.getPlatforms().get(i).getRect().getX())))
				setDX(0);
			if (getRect().intersects(Platform.getPlatforms().get(i).getRect()) && ((getDY() > 0 && getY() < Platform.getPlatforms().get(i).getRect().getY())||(getDX() < 0 && getY() > Platform.getPlatforms().get(i).getRect().getY())))
				setDY(0);
		}
		setLocation(getX() + getDX(), getY() + getDY());
	}
	
	public class smash implements Runnable
	{
		public void run()
		{
			try
			{
				while(alive)
				{
					for(int i = -6; i <= 6; i++)
					{
						setDY(i);
						Thread.sleep(200 - 20*Math.abs(i));
					}
					setDX((int)(5*Math.random()+1));
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
