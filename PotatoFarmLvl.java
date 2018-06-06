import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PotatoFarmLvl extends JPanel implements ActionListener
{
	private JLabel jimmerjamer;
	private JLabel lololol;
	private boolean s1ended;
	private boolean s2ended;
	private boolean s3ended;
	private boolean b1ended;
	private boolean c1ended;
	private boolean c2ended;
	private boolean c3ended;
	private boolean b2ended;
	private boolean 
	private JLabel switcher;
	private MasterFrame master;
	private boolean backgroundcheck;
	private ChickenNugger player;
	private FrenchFriedMinion ffm1;
	private FrenchFriedMinion ffm2;
	private FrenchFriedMinion ffm3;
	private FrenchFriedMinion ffm4;
	private FrenchFriedMinion ffm5;
	private FrenchFriedMinion ffm6;
	private Platform smallplat1;
	private Platform smallplat2;
	private Platform csmallplat1;
	private Platform csmallplat2;
	private Platform csmallplat3;
	private Platform csmallplat4;
	private Platform csmallplat5;
	private Platform csmallplat6;
	private Platform plat1;
	private Platform plat2;
	private Platform plat3;
	private Platform cplat1;
	private Platform cplat2;


	private Platform bigplat1;
	private Wall wall1;
	private Platform base1;
	private Platform base2;
	private Platform base3;
	private Platform cbase1;
	private Platform cbase2;
	private Platform cbase3;
	private JLabel jamjam;
	
	public PotatoFarmLvl(MasterFrame mas)
	{	

		s1ended = true;
		s2ended = true;
		s3ended = true;
		b1ended = true;
		c1ended = true;
		master = mas;
		setBounds(0, 0, master.getWidth(), master.getHeight());
		backgroundcheck = false;
		ChickenNugger testie = new ChickenNugger(0, 0);
		player = new ChickenNugger(0, getHeight() - testie.getHeight() - 92);
		add(player);

		FrenchFriedMinion nyoom = new FrenchFriedMinion(0, 0);
		ffm1 = new FrenchFriedMinion(760, master.getHeight() - nyoom.getHeight() - 92);
		add(ffm1);
		ffm2 = new FrenchFriedMinion(800, master.getHeight() - nyoom.getHeight() - 92);
		add(ffm2);
		ffm3 = new FrenchFriedMinion(850, master.getHeight() - nyoom.getHeight() - 92);
		add(ffm3);
		ffm4 = new FrenchFriedMinion(900, master.getHeight() - nyoom.getHeight() - 92);
		add(ffm4);
		ffm5 = new FrenchFriedMinion(950, master.getHeight() - nyoom.getHeight() - 92);
		add(ffm5);
		ffm6 = new FrenchFriedMinion(master.getWidth() / 2 + 100, master.getHeight()/3 - ffm5.getHeight());
		add(ffm6);
		Timer timer = new Timer(1000/60, this);
		timer.start();
		

		setLayout(null);
		Platform test = new Platform(0,0);
		base1 = new Platform(0, master.getHeight() - test.getHeight());
		add(base1);
		base2 = new Platform(base1.getWidth() - 10, master.getHeight() - test.getHeight());
		add(base2);
		base3 = new Platform(base1.getWidth()*2 - 20, master.getHeight() - test.getHeight());
		add(base3);
		plat1 = new Platform(master.getWidth()/3, master.getHeight() / 2, 200);
		add(plat1);
		plat2 = new Platform(master.getWidth()/2, master.getHeight() / 3, 200);
		add(plat2);
		plat3 = new Platform(3*master.getWidth()/4, master.getHeight() / 3, 200);
		add(plat3);
		smallplat1 = new Platform(master.getWidth()/2, 3*master.getHeight()/5, 100);
		smallplat2 = new Platform(master.getWidth() / 3, 3*master.getHeight()/5, 100);
		bigplat1 = new Platform(master.getWidth() / 3, master.getHeight() / 2);
		Wall testwall = new Wall(0,0);
		wall1 = new Wall(master.getWidth() / 3 + bigplat1.getWidth(), bigplat1.getY() - testwall.getHeight() + bigplat1.getHeight());
		Platform cbasetest = new Platform(0,0,"yes");
		cbase1 = new Platform(0, master.getHeight() - cbasetest.getHeight(),"yes");
		cbase2 = new Platform(cbase1.getWidth(),master.getHeight() - cbasetest.getHeight(),"yes");
		cbase3 = new Platform(2*cbase1.getWidth(),master.getHeight() - cbasetest.getHeight(),"yes");
		cplat1 = new Platform(0, master.getHeight() - cbasetest.getHeight(),"yes");
		cplat2 = new Platform(master.getWidth() / 2 - cplat1.getWidth() / 2, master.getHeight()/2, 500, 10000);
		csmallplat1 = new Platform(0, master.getHeight() - cplat1.getHeight(), 100, 10000);
		csmallplat2 = new Platform(master.getWidth()/8, 7*master.getHeight()/10, 100, 10312);
		csmallplat3 = new Platform(3*master.getWidth()/4, 2*master.getHeight()/5, 100, 10312);
		csmallplat4 = new Platform(0, master.getHeight() - cplat1.getHeight(), 100, 10000);
		csmallplat5 = new Platform(master.getWidth()/8, 7*master.getHeight()/10, 100, 10312);
		csmallplat6 = new Platform(3*master.getWidth()/4, 2*master.getHeight()/5, 100, 10312);
//		add(bigplat1);
//		bigplat1.setVisible(false);

		BufferedImage background = null;
		try
		{
			background = ImageIO.read(new File("potato-farm.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		ImageIcon jimster = new ImageIcon(background);
		jamjam = new JLabel(jimster);
		jamjam.setBounds(0, 0, background.getWidth(), background.getHeight());
		add(jamjam);
//		ChickenNugger testie = new ChickenNugger(0,0);
//		player = new ChickenNugger(0, master.getHeight() - testie.getHeight() - 92);
//		add(player);
//		BufferedImage base2 = null;
//		try
//		{
//			base2 = ImageIO.read(new File("platform image.jpg"));
//		}
//		catch(IOException e1)
//		{
//			e1.printStackTrace();
//		}
//		JLabel base2l = new JLabel(new ImageIcon(base2));
//		base2l.setPreferredSize(new Dimension(base2.getHeight(), base2.getWidth()));
//		base2l.setBounds(base1.getWidth() - 10, master.getHeight() - base2.getHeight(), base2.getWidth(), base2.getHeight());
//		base2l.setVisible(true);
//		add(base2l);
//		BufferedImage base3 = null;
//		try
//		{
//			base3 = ImageIO.read(new File("platform image.jpg"));
//		}
//		catch(IOException e1)
//		{
//			e1.printStackTrace();
//		}
//		JLabel base3l = new JLabel(new ImageIcon(base3));
//		base3l.setPreferredSize(new Dimension(base3.getHeight(), base3.getWidth()));
//		base3l.setBounds(base1.getWidth()*2 - 20, master.getHeight() - base3.getHeight(), base3.getWidth(), base3.getHeight());
//		base3l.setVisible(true);
//		add(base3l);
		
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		ffm1.update();
		ffm2.update();
		ffm3.update();
		ffm4.update();
		ffm5.update();
		ffm6.update();
		if(s1ended && player.getX() + player.getWidth() >= master.getWidth())
		{
			s1ended = false;
			sect2();
		}
		if(s2ended && player.getX() + player.getWidth() >= master.getWidth())
		{
			s2ended = false;
			sect3();
		}
		if(s3ended && player.getX() + player.getWidth() >= master.getWidth())
		{
			s3ended = false;
			boss1lvl();
		}
		if(b1ended && player.getX() + player.getWidth() >= master.getWidth())
		{
			b1ended = false;
			lvl2begin();
		}
		if(c1ended && player.getX() + player.getWidth() >= master.getWidth())
		{
			c1ended = false;
			csect2();
		}
		if(c2ended && player.getX() + player.getWidth() >= master.getWidth())
		{
			c2ended = false;
			csect3();
		}
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
//			
//		BufferedImage background = null;
//		try
//		{
//			background = ImageIO.read(new File("potato-farm.jpg"));
//		}
//		catch(IOException e1)
//		{
//			e1.printStackTrace();
//		}
//		g.drawImage(background, 0, 0, this);

	}
	
	public Platform getBL()
	{
		return base1;
	}

	public ChickenNugger getPlayer()
	{
		return player;
	}
	
	public void sect2()
	{
		ffm1.setLocation(bigplat1.getWidth() + master.getWidth() / 3 - 1 - ffm1.getWidth(), master.getHeight() / 2 + 1 - ffm1.getHeight());
		remove(ffm2);
		remove(ffm3);
		remove(ffm4);
		remove(ffm5);
		remove(ffm6);
		remove(plat2);
		remove(plat3);
		plat1.setLocation(0, player.getHeight() + 5);
		remove(jamjam);
		add(bigplat1);
		add(wall1);
		add(jamjam);
		player.setLocation(0, bigplat1.getHeight() - player.getHeight()/2);
		

		
		
	}
	public void sect3()
	{

		remove(ffm1);
		remove(base1);
		remove(base2);
		remove(base3);
		remove(wall1);
		remove(jamjam);
		plat1.setLocation(0, 2*master.getHeight() / 3);
		bigplat1.setLocation(master.getWidth() - bigplat1.getWidth(),bigplat1.getY());
		add(smallplat1);
		add(smallplat2);
		add(jamjam);
		player.setLocation(plat1.getX(), plat1.getY() - player.getHeight());
	}
	
	public void boss1lvl()
	{
		remove(smallplat1);
		remove(plat1);
		remove(smallplat2);
		remove(jamjam);
		remove(bigplat1);
		add(base1);
		add(base2);
		add(base3);
		add(jamjam);
		player.setLocation(0, base1.getY() - player.getHeight());
	}

	public void lvl2begin()
	{
		remove(base1);
		remove(base2);
		remove(base3);
		remove(jamjam);
		add(csmallplat1);
		add(csmallplat2);
		add(csmallplat3);
		add(cplat2);
		add(jamjam);
		player.setLocation(0, cbase1.getY() - player.getHeight());
		
	}
	public void csect2()
	{
		remove(jamjam);
		csmallplat1.setLocation(0, master.getHeight()/3);
		csmallplat2.setLocation(master.getWidth()/6, master.getHeight()/3);
		csmallplat3.setLocation(2*master.getWidth()/6, 2*master.getHeight()/3);
		csmallplat4.setLocation(3*master.getWidth()/6, 3*master.getHeight()/4);
		csmallplat5.setLocation(4*master.getWidth()/6, 3*master.getHeight()/5);
		csmallplat6.setLocation(5*master.getWidth()/6, master.getHeight()/3);
		add(csmallplat4);
		add(csmallplat5);
		add(csmallplat6);
		remove(cplat2);
		add(jamjam);
		player.setLocation(0, master.getHeight()/3 - player.getHeight());
	}
	
	public void csect3()
	{
		
	}
	
	


}
