import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class FrenchFried extends JComponent
{
	private int dx = 0, dy = 0;
	
	private BufferedImage image = null;
	
	public FrenchFried(int x, int y)
	{
		setLocation(x, y);
		setSize(500,500);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 3, 4, this);
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
