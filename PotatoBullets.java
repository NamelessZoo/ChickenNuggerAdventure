import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class PotatoBullets extends JComponent
{
	private int dx;
	
	private BufferedImage image;
	private Rectangle2D size;
	
	private String potatoBullet = "potatobullet.jpg";
	
	public PotatoBullets(int x, int y)
	{
		setLocation (x,y);
		setSize(500,500);
		try
		{
			image = ImageIO.read(new File(potatoBullet));
			size = new Rectangle2D.Double(getX(), getY(), image.getWidth(), image.getHeight());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void paintComponent (Graphics g)
	{
		g.drawImage(image, 0, 0, this);
		size = new Rectangle2D.Double(getX(), getY(), image.getWidth(), image.getHeight());
	}
	
	public void update()
	{
		setLocation (getX() + dx, getY());
	}
}
