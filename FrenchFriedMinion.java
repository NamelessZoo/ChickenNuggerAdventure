import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class FrenchFriedMinion extends JComponent
{
	private int dx = -1;
	private int hp;
	
	private BufferedImage image = null;
	
	private String frenchFriedMinion = "frenchminion.PNG";
	
	public FrenchFriedMinion(int x, int y)
	{
		setLocation(x, y);
		setSize(500,500);
		hp = 15;
		try 
		{
			image = ImageIO.read(new File(frenchFriedMinion));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public void setHP(int health)
	{
		hp = health;
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void update()
	{
		if (hp <= 0)
			image = null;
		if (getX() == 0)
			dx = 0;
		setLocation(getX() + dx, getY());
	}
}
