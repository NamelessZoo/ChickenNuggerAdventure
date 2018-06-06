import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Platform extends JLabel
{
	private BufferedImage image;
	private Rectangle2D size;
	
	private static ArrayList<Platform> platforms = new ArrayList<Platform>();
	
	public Platform(int x, int y)
	{
		image = null;
		try
		{
			image = ImageIO.read(new File("platform image.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(image);
//		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		setBounds(x, y, image.getWidth(), image.getHeight());
		size = new Rectangle2D.Double(getX(), getY(), image.getWidth(), image.getHeight());
		platforms.add(this);
		setVisible(true);
		setIcon(icon);

	}
	
	public Platform(int x, int y, int x1)
	{
		super();
		image = null;
		try
		{
			image = ImageIO.read(new File("platform image.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		ImageIcon image1 = new ImageIcon(image);
//		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		setBounds(x, y, x1, 92);
		setVisible(true);
		setIcon(image1);
		platforms.add(this);
	}
	
	public Platform(int x, int y, String yeahboi)
	{
		super();
		image = null;
		try
		{
			image = ImageIO.read(new File("cityplat.png"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		ImageIcon image1 = new ImageIcon(image);
//		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		setBounds(x, y, image.getWidth(), image.getHeight());
		setVisible(true);
		setIcon(image1);
		platforms.add(this);
	}
	
	public Platform(int x, int y, int x1, int yeahboi)
	{
		super();
		image = null;
		try
		{
			image = ImageIO.read(new File("cityplat.png"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		ImageIcon image1 = new ImageIcon(image);
//		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		setBounds(x, y, x1, image.getHeight());
		setVisible(true);
		setIcon(image1);
		platforms.add(this);
	}
	
	public Rectangle2D getRect()
	{
		return size;
	}
	
	public static ArrayList<Platform> getPlatforms()
	{
		return platforms;
	}

}
