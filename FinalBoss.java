import java.awt.Graphics;

import javax.swing.JComponent;

public class FinalBoss extends JComponent
{
	private int dx = 0, dy = 0;
	
	public FinalBoss(int x, int y)
	{
		setLocation(x, y);
	}
	
	public void paintComponent(Graphics g)
	{
		
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
