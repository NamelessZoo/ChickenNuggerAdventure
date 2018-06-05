import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class HireWireJugggler extends Character
{
	private int hp;
	
	private boolean alive = false;
	private static boolean dropping = false;
	
	private BufferedImage image;
	
	private String pic1 = "highwirejuggler.jpg";
	private String pic2 = "highwirejuggler - Copy.jpg";
	private String pic3 = "highwirejuggler - Copy (2).jpg";
	private String pic4 = "highwirejuggler - Copy (3).jpg";
	private String pic5 = "highwirejuggler - Copy (4).jpg";
	
	public HireWireJugggler(int x, int y)
	{
		super(x,y);
		super.setDX(1250);
		super.setDY(600);
		try
		{
			image = ImageIO.read(new File(pic1));
			setSize(image);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		hp = 1000;
		alive = true;
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
		setSize(image);
	}
	
	public void animate()
	{
		new Thread(new animate()).start();
	}
	
	public void update()
	{
		setDX((int)(3*Math.random()) - 1);
		setLocation(getX() + getDX(), getY() + getDY());
	}
	
	public class animate implements Runnable
	{
		public void run()
		{
			try
			{
				while(alive)
				{
					image = ImageIO.read(new File(pic1));
					Thread.sleep(200);
					image = ImageIO.read(new File(pic2));
					Thread.sleep(200);
					image = ImageIO.read(new File(pic3));
					Thread.sleep(200);
					image = ImageIO.read(new File(pic4));
					Thread.sleep(200);
					image = ImageIO.read(new File(pic5));
					Thread.sleep(200);
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
	public class dropping implements Runnable
	{
		public void run()
		{
			try
			{
				while(alive)
				{
					
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
