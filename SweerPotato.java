import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class SweerPotato extends Character
{
	private int dx = 0, dy = 0;
	
	private BufferedImage image;
	
	public SweerPotato(int x, int y)
	{
		super(x,y);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
		setSize(image);
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
}
