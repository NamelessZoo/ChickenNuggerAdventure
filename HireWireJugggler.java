import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class HireWireJugggler extends Character
{
	private static boolean alive = false;
	
	private ArrayList<Bomb> bombs;
	private Bomb bomb;
	private JFrame frame;
	
	private BufferedImage image;
	
	private String pic1 = "hwj.png";
	private String pic2 = "hwj2.png";
	private String pic3 = "hwj3.png";
	private String pic4 = "hwj4.png";
	private String pic5 = "hwj5.png";
	
	private int bottom = 500;
	
	public HireWireJugggler(int x, int y)
	{
		super(x,y);
		try
		{
			image = ImageIO.read(new File(pic1));
			setSize(image);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		setHP(1000);
		alive = true;
		bombs = new ArrayList<Bomb>();
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
	
	public void bombDrop(JFrame good)
	{
		frame = good;
		new Thread(new bomb()).start();
	}
	
	public ArrayList<Bomb> getBombs()
	{
		return bombs;
	}
	
	public void update()
	{
		if ((getX() <= 0 && getDX() < 0) || (getX() >= 1920 && getDX() > 0))
			setDX(0);
		setLocation(getX() + getDX(), getY() + getDY());
	}
	
	public class animate implements Runnable
	{
		public void run()
		{
			try
			{
				for (int i = 0; i < 60; i++)
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
					setDX((int)(10*Math.random() - 5));
				}
				setDX(5);
				Thread.sleep(1000);
				setDX(0);
				while (getY() < bottom)
					setDY(-1);
				setDY(0);
				setDX(-20);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
	
	public class bomb implements Runnable
	{
		public void run()
		{
			try
			{
				while(alive)
				{
					Thread.sleep((int)(2000*Math.random() + 1));
					bomb = new Bomb(getX(), getY());
					bombs.add(bomb);
					frame.add(bomb);
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
