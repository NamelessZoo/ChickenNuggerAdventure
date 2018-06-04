import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Platform extends JLabel
{
	private BufferedImage image;
	
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
		setVisible(true);
		setIcon(icon);

	}
	
	public Platform(int x, int y, int x1, int y1)
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

//		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		setBounds(x, y, x1, y1);
		setVisible(true);
		setIcon((Icon)image);

	}
}
