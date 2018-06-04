import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;


public class Tutorial extends JPanel implements ActionListener
{
	private double ssw = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double ssh = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	private double maswid;
	private double mashei;
	private JLabel tutInfo;
	private boolean cont1;
	private boolean cont2;
	private boolean cont3;
	private boolean cont4;
	int time = 0;
	private Scanner in;
	private ChickenNugger player;
	
	public Tutorial(MasterFrame master)
	{
		tutInfo = new JLabel("Welcome to Chicken Nugger Adventure!");
		tutInfo.setSize(225, 16);
		tutInfo.setLocation((int)maswid / 2 - tutInfo.getWidth() / 2, (int)mashei/4);
		tutInfo.setForeground(Color.BLACK);
		Timer timer = new Timer(10, this);
		timer.start();
		in = new Scanner(System.in);
		
		
		setLayout(null);
		maswid = master.retWidth();
		mashei = master.retHeight();
		setBounds(0, 0, (int)maswid, (int)mashei);
	
		TutRect grassyknoll = new TutRect(mashei, maswid);
		add(grassyknoll);
		player = new ChickenNugger(100, 330);
		add(player);
		add(tutInfo);
		cont1 = false;
		cont2 = false;


	}
	public void actionPerformed(ActionEvent e) 
	{
		tutInfo.setSize(tutInfo.getPreferredSize());
		tutInfo.setLocation((int)maswid / 2 - tutInfo.getWidth() / 2, (int)mashei/4);
		repaint();
	}
	
	
	public void setTutInfo(String s)
	{
		if(s.equals("Absolutely radical bro! You have completed the tutorial. Now you are ready to start the game."))
		{
			System.out.println("gg it got here");
		}
		if(s.equals("Awesome! Now, press R to go into super mode when you have a full ketchup meter!"))
		{
			System.out.println("bruh dude");
		}
		tutInfo.setText(s);
	}
	
	public void setCont1(boolean gg)
	{
		cont1 = gg;
	}
	
	public void setCont2(boolean gg)
	{
		cont2 = gg;
	}
	public void setCont3(boolean gg)
	{
		cont3 = gg;
	}
	public void setCont4(boolean gg)
	{
		cont4 = gg;
	}
	
	public boolean getCont1()
	{
		
		return cont1;
	}
	
	public boolean getCont2()
	{
	
		return cont2;
	}
	public boolean getCont3()
	{
	
		return cont3;
	}
	public boolean getCont4()
	{
	
		return cont4;
	}
	
	public ChickenNugger getPlayer()
	{
		return player;
	}
	
}
