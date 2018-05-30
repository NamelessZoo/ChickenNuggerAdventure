import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FrenchFriedMinion extends Character
{	
	private BufferedImage image = null;
	
	private String frenchFriedMinion = "frenchminion.PNG";
	
	public FrenchFriedMinion(int x, int y)
	{
		setLocation(x, y);
		setDX(-1);
		setHP(15);
		try 
		{
			image = ImageIO.read(new File(frenchFriedMinion));
			setSize(image);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
		setSize(image);
	}

	public void update()
	{
		if (getHP() <= 0)
		{
			try 
			{
				image = ImageIO.read(new File("CHICKENNUGGER.png"));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		if (getX() == 0)
			setDX(0);
		setLocation(getX() + getDX(), getY() + getDY());
	}
}
