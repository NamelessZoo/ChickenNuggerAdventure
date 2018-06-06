import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class GunDrop extends Item
{	
private BufferedImage image;
	
	private String gunDrop = "toygun.png";
	
	private Rectangle2D size;
	
	public GunDrop (int x, int y)
	{
		super(x,y);
		try
		{ 
			image = ImageIO.read(new File(gunDrop));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		size = new Rectangle2D.Double(getX(), getY(), image.getWidth(), image.getHeight());
	}
	
	public Rectangle2D getRect()
	{
		return size;
	}
	
	public void effect(ChickenNugger a)
	{
		a.shooting();
		image = null;
	}
}
