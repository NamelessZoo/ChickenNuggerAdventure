import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ChickenNugger extends JComponent
{
	private int dx = 0, dy = 0;
	private int hp, ketchup, lvl;
	private BufferedImage image = null;
	
	public ChickenNugger(int x, int y)
	{
		setLocation(x, y);
		setSize(1000,1000);
		hp = 100;
		ketchup = 0;
		lvl = 1;
		try 
		{
			image = ImageIO.read(new File("ChickenNugger.jpg"));
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
	
	public int getHP()
	{
		return hp;
	}
	
	public void setHP(int health)
	{
		hp = health;
	}
	
	public int getSP()
	{
		return ketchup;
	}
	
	public void setSP(int special)
	{
		ketchup = special;
	}
	
	public int getLvl()
	{
		return lvl;
	}
	
	public void lvlUp()
	{
		lvl++;
	}
	
	public void setDY(int y)
	{
		dy = y;
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
}
