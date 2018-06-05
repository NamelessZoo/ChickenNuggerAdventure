import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;

public abstract class Character extends JComponent
{
	private int dx, dy;
	
	private int hp;
	
	private static ArrayList<Character> two = new ArrayList<Character>();
	private static ArrayList<Integer> damageUsers = new ArrayList<Integer>();
	private static ArrayList<Integer> damageGetters = new ArrayList<Integer>();
	
	private Rectangle2D size;
	
	public Character(int x, int y)
	{
		setLocation(x,y);
	}
	
	public void setSize(BufferedImage image)
	{
		size = new Rectangle2D.Double(getX(), getY(), image.getWidth(), image.getHeight());
		setSize(image.getWidth(), image.getHeight());
	}
	
	public Rectangle2D getRect()
	{
		return size;
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void setDY(int y)
	{
		dy = y;
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public int getDY()
	{
		return dy;
	}
	
	public void setHP(int h)
	{
		hp = h;
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public void contact(Character b, int d1, int d2)
	{
		two.add(b);
		damageUsers.add(d1);
		damageGetters.add(d2);
		new Thread(new contact()).start();
	}
	
	public class contact implements Runnable
	{
		public void run()
		{
			try
			{
				for (int i = 0; i < two.size(); i++)
				{
					if (ChickenNugger.isPunching() && getRect().intersects(two.get(i).getRect()) && getX() < two.get(i).getX() && !ChickenNugger.isLeft())
					{
						two.get(i).setDX(3);
						Thread.sleep(250);
						two.get(i).setHP(getHP() - damageGetters.get(i).intValue());
					}
					else if (ChickenNugger.isPunching() && getRect().intersects(two.get(i).getRect()) && getX() > two.get(i).getX() && ChickenNugger.isLeft())
					{
						two.get(i).setDX(-3);
						Thread.sleep(250);
						two.get(i).setHP(getHP() - damageGetters.get(i).intValue());
					}
					else if (getRect().intersects(two.get(i).getRect()) && getX() < two.get(i).getX() && getDX() >= 0)
					{
						setDX(-3);
						two.get(i).setDX(3);
						for (int j = 0; j < damageUsers.get(i).intValue(); j++)
						{
							Bars.setHP(Bars.getHP() - 1);
							Thread.sleep(25);
						}
						Thread.sleep(500);
						setDX(0);
						two.get(i).setDX(-1);
					}
					else if (getRect().intersects(two.get(i).getRect()) && getX() > two.get(i).getX() && getDX() <= 0)
					{
						setDX(3);
						two.get(i).setDX(-3);
						for (int j = 0; j < damageUsers.get(i).intValue(); j++)
						{
							Bars.setHP(Bars.getHP() - 1);
							Thread.sleep(25);
						}
						Thread.sleep(500);
						setDX(0);
						two.get(i).setDX(-1);
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
}
