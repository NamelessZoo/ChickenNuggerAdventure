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
		new Thread(new )
	}
	
	public void update()
	{
		setLocation(getX() + getDX(), getY() + getDY());
	}
}
