import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class SweerPotatoMinion extends Character
{
	private boolean alive = true;
	
	private BufferedImage image;
	
	private String sweerPotatoMinion = "SweetPotatominion.png";
	
	public SweerPotatoMinion(int x, int y)
	{
		super(x,y);
		try
		{
			image = ImageIO.read(new File(sweerPotatoMinion));
			setSize(image);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		setHP(20);
		setDX(-2);
		alive = true;
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
		setSize(image);
	}
	
	public void update()
	{
		setLocation(getX() + getDX(), getY() + getDY());
	}
}
