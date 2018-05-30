import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class Character extends JComponent
{
	private int dx, dy;
	private static int damageUser, damageGetter;
	
	private int hp;
	
	private Character two;
	
	private Rectangle2D size;
	
	private boolean takingDamage = false;
	
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
		two = b;
		damageUser = d1;
		damageGetter = d2;
		new Thread(new contact()).start();
	}
	
	public class contact implements Runnable
	{
		public void run()
		{
			try
			{
				if (ChickenNugger.isPunching() && getRect().intersects(two.getRect()) && getX() < two.getX() && !ChickenNugger.isLeft())
				{
					two.setDX(3);
					Thread.sleep(250);
					two.setHP(getHP() - damageGetter);
				}
				else if (ChickenNugger.isPunching() && getRect().intersects(two.getRect()) && getX() > two.getX() && ChickenNugger.isLeft())
				{
					two.setDX(-3);
					Thread.sleep(250);
					two.setHP(getHP() - damageGetter);
				}
				else if (getRect().intersects(two.getRect()) && getX() < two.getX() && getDX() >= 0)
				{
					setDX(-3);
					two.setDX(3);
					takingDamage = true;
					for (int i = 0; i < damageUser; i++)
					{
						Bars.setHP(Bars.getHP() - 1);
						Thread.sleep(25);
					}
					takingDamage = false;
					Thread.sleep(500);
					setDX(0);
					two.setDX(-1);
				}
				else if (getRect().intersects(two.getRect()) && getX() > two.getX() && getDX() <= 0)
				{
					setDX(3);
					two.setDX(-3);
					takingDamage = true;
					for (int i = 0; i < damageUser; i++)
					{
						Bars.setHP(Bars.getHP() - 1);
						Thread.sleep(25);
					}
					takingDamage = false;
					Thread.sleep(500);
					setDX(0);
					two.setDX(-1);
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
