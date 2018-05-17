import java.awt.Graphics;

import javax.swing.JComponent;

public class FrenchFriedMinion extends JComponent
{
	private int dx = 0;
	private int hp;
	
	public FrenchFriedMinion(int x, int y)
	{
		setLocation(x, y);
		hp = 15;
	}
	
	public void paintComponent(Graphics g)
	{
		
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public void setHP(int health)
	{
		hp = health;
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY());
	}
}
