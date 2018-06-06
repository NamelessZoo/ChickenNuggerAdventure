import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class SweerPotato extends Character
{
	private static boolean alive = false;
	
	private ArrayList<PotatoBullets> bullets;
	private PotatoBullets bullet;
	private JFrame frame;
	
	private BufferedImage image;
	
	private String potato = "SweerPotato.png";
	
	public SweerPotato(int x, int y)
	{
		super(x,y);
		try
		{
			image = ImageIO.read(new File(potato));
			setSize(image);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		setHP(1000);
		alive = true;
		bullets = new ArrayList<PotatoBullets>();
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
		setSize(image);
	}
	
	public void shoot(JFrame good)
	{
		frame = good;
		new Thread(new shoot()).start();
	}

	public ArrayList<PotatoBullets> getBullets()
	{
		return bullets;
	}
	
	public void update()
	{
		setLocation(getX() + getDX(), getY() + getDY());
	}
	
	public class shoot implements Runnable
	{
		public void run()
		{
			try
			{
				while(alive)
				{
					Thread.sleep((int)(1000*Math.random() + 1));
					bullet = new PotatoBullets(getX() + 200, getY() + 25);
					bullets.add(bullet);
					frame.add(bullet);
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
