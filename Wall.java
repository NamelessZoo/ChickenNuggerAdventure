import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Wall extends JLabel
{
	private BufferedImage image;
	
	public Wall(int x, int y)
	{
		image = null;
		try
		{
			image = ImageIO.read(new File("wall.png"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(image);
//		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		setBounds(x, y, image.getWidth(), image.getHeight());
		setVisible(true);
		setIcon(icon);

	}
	
	public Wall(int x, int y, int y1)
	{
		super();
		image = null;
		try
		{
			image = ImageIO.read(new File("wall.png"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}

////		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
//		setBounds(x, y, x1, image.getHeight());
//		setVisible(true);
//		setIcon((Icon)image);

		ImageIcon icon = new ImageIcon(image);
//		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		setBounds(x, y, image.getWidth(), y1);
		setVisible(true);
		setIcon(icon);

	}
	
	public BufferedImage getImage()
	{
		return image;
	}
}
