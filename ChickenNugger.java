import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ChickenNugger extends Character
{
	private int heal, gain;

	private boolean superMode = false;
	private boolean jumping = false;
	private static boolean left = false;
	private static boolean punching = false;
	private static boolean shooting = false;
	
	private int frameWidth = 1366;
	private int frameHeight = 768;
	
	private BufferedImage image = null;
	
	private String chickenNugger = "CHICKENNUGGER.png";
	private String chickenNuggerPunch = "CHICKENNUGGERPUNCH.png";
	private String chickenNuggerSuper = "CHICKENNUGGERSUPER.png";
	private String chickenNuggerSuperPunch = "CHICKENNUGGERSUPERPUNCH.png";
	private String chickenNuggerLeft = "CHICKENNUGGERLEFT.png";
	private String chickenNuggerLeftPunch = "CHICKENNUGGERLEFTPUNCH.png";
	private String chickenNuggerLeftSuper = "CHICKENNUGGERLEFTSUPER.png";
	private String chickenNuggerLeftSuperPunch = "CHICKENNUGGERLEFTSUPERPUNCH.png";
	private String chickenNuggerGun = "nuggetweapon.png";
	private String chickenNuggerGunLeft = "nuggetweaponleft.png";
	private String chickenNuggerDead = "deadnugget.png";
	
	public ChickenNugger(int x, int y)
	{
		super(x,y);
		super.setDX(0);
		super.setDY(0);
		try 
		{
			image = ImageIO.read(new File(chickenNugger));
			setSize(image);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("DERPY PEOPLES MUSIC.wav"));
         		Clip clip = AudioSystem.getClip();
         		clip.open(audioIn);
         		clip.start();
        		clip.loop(Clip.LOOP_CONTINUOUSLY);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
      		catch (UnsupportedAudioFileException e) 
		{
         		e.printStackTrace();
      		} 
		catch (LineUnavailableException e) 
		{
         		e.printStackTrace();
      		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
		setSize(image);
	}
	
	public void setDX(int x)
	{
		super.setDX(x);
		try 
		{
			if (x > 0)
			{
				left = false;
				if (superMode)
				{
					image = ImageIO.read(new File(chickenNuggerSuper));
				}
				else if (shooting)
				{
					image = ImageIO.read(new File(chickenNuggerGun));
				}
				else
				{
					image = ImageIO.read(new File(chickenNugger));
				}
			}
			if (x < 0)
			{
				left = true;
				if (superMode)
				{
					image = ImageIO.read(new File(chickenNuggerLeftSuper));
				} 
				else if (shooting)
				{
					image = ImageIO.read(new File(chickenNuggerGunLeft));
				}
				else
				{
					image = ImageIO.read(new File(chickenNuggerLeft));
				}
			}
		}	
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void jumping()
	{
		if (!jumping)
		{
			new Thread(new jumper()).start();
		}
	}
	
	public void superMode()
	{
		if (Bars.getSP() == 100)
		{
			new Thread(new ult()).start();
		}
	}
	
	public void punching()
	{
		new Thread(new puncher()).start();
	}
	
	public void shooting()
	{
		try 
		{
			if (!superMode)
			{
				shooting = true;
				image = ImageIO.read(new File(chickenNuggerGun));
				Bars.setAmmo(10);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static boolean isPunching()
	{
		return punching;
	}
	
	public static boolean isLeft()
	{
		return left;
	}
	
	public static boolean isShooting()
	{
		return shooting;
	}
	
	public void healed(int h)
	{
		heal = h;
		new Thread(new heal()).start();
	}
	
	public void spGain(int s)
	{
		gain = s;
		new Thread(new gainSP()).start();
	}
	
	public void pickItem(Item a)
	{
		if (getRect().intersects(a.getRect()))
			a.effect(this);
	}
	
	public void update()
	{
		if ((getX() <= 0 && getDX() < 0) || (getX() >= frameWidth && getDX() > 0))
			setLocation(getX(), getY() + getDY());
		else
			setLocation(getX() + getDX(), getY() + getDY());
		if (isShooting() && Bars.getAmmo() == 0)
		{
			shooting = false;
			try 
			{
				image = ImageIO.read(new File(chickenNugger));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		if (Bars.getHP() <= 0)
		{
			try 
			{
				image = ImageIO.read(new File(chickenNuggerDead));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		for (int i = 0; i < Platform.getPlatforms().size(); i++)
		{
			if (jumping && getRect().intersects(Platform.getPlatforms().get(i).getRect()) && getY() <= Platform.getPlatforms().get(i).getY() + getHeight() && getX() >= Platform.getPlatforms().get(i).getX())
			{
				setDY(0);
				jumping = false;
			}
		}
	}
	
	public class ult implements Runnable
	{
		public void run()
		{
			try
			{
				if (!shooting)
				{
					superMode = true;
					image = ImageIO.read(new File(chickenNuggerSuper));
					for (int i = 1; i <= 100; i++)
					{
						Bars.setSP(100-i);
						Thread.sleep(100);
					}
					image = ImageIO.read(new File(chickenNugger));
					superMode = false;
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
	
	public class jumper implements Runnable
	{
		public void run()
		{
			try
			{
				for(int i = -5; i <= 5; i++)
				{
					setDY(i);
					Thread.sleep(200 - 5*Math.abs(i));
					jumping = true;
				}
				jumping = false;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
	
	public class puncher implements Runnable
	{
		public void run()
		{
			try
			{
				punching = true;
				if (!shooting)
				{
					if (superMode && left)
					{
						image = ImageIO.read(new File(chickenNuggerLeftSuperPunch));
						Thread.sleep(200);
						image = ImageIO.read(new File(chickenNuggerLeftSuper));
					}
					else if (superMode)
					{
						image = ImageIO.read(new File(chickenNuggerSuperPunch));
						Thread.sleep(200);
						image = ImageIO.read(new File(chickenNuggerSuper));
					}
					else if (left)
					{
						image = ImageIO.read(new File(chickenNuggerLeftPunch));
						Thread.sleep(200);
						image = ImageIO.read(new File(chickenNuggerLeft));
					}
					else
					{
						image = ImageIO.read(new File(chickenNuggerPunch));
						Thread.sleep(200);
						image = ImageIO.read(new File(chickenNugger));
					}
				}
				Thread.sleep(500);
				punching = false;
			}
			catch (Exception e)
			{
				 e.printStackTrace();;
				 new Thread(this).start();
				 System.exit(0);
			}
		}
	}
	
	public class heal implements Runnable
	{
		public void run()
		{
			try
			{
				for (int i = 0; i < heal; i++)
				{
					if (Bars.getHP() < 100)
					{
						Bars.setHP(Bars.getHP() + 1);
						Thread.sleep(25);
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
	
	public class gainSP implements Runnable
	{
		public void run()
		{
			try
			{
				for (int i = 0; i < gain; i++)
				{
					if (Bars.getSP() < 100)
					{
						Bars.setSP(Bars.getSP() + 1);
						Thread.sleep(25);
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
