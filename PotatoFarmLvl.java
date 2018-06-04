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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PotatoFarmLvl extends JPanel implements ActionListener
{
	private JLabel switcher;
	private MasterFrame master;
	private BufferedImage base1;
	
	public PotatoFarmLvl(MasterFrame mas)
	{
		master = mas;
		Timer timer = new Timer(10, this);
		timer.start();
		switcher = new JLabel("LEVEL 1-1");
		switcher.setForeground(Color.WHITE);
		add(switcher);
		setBounds(0, 0, master.getWidth(), master.getHeight());
		setLayout(null);
		base1 = null;
		try
		{
			base1 = ImageIO.read(new File("platform image.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		JLabel base1l = new JLabel(new ImageIcon(base1));
		base1l.setPreferredSize(new Dimension(base1.getHeight(), base1.getWidth()));
		base1l.setBounds(0, master.getHeight() - base1.getHeight(), base1.getWidth(), base1.getHeight());
		base1l.setVisible(true);
		add(base1l);
		BufferedImage base2 = null;
		try
		{
			base2 = ImageIO.read(new File("platform image.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		JLabel base2l = new JLabel(new ImageIcon(base2));
		base2l.setPreferredSize(new Dimension(base2.getHeight(), base2.getWidth()));
		base2l.setBounds(base1.getWidth() - 10, master.getHeight() - base2.getHeight(), base2.getWidth(), base2.getHeight());
		base2l.setVisible(true);
		add(base2l);
		BufferedImage base3 = null;
		try
		{
			base3 = ImageIO.read(new File("platform image.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		JLabel base3l = new JLabel(new ImageIcon(base3));
		base3l.setPreferredSize(new Dimension(base3.getHeight(), base3.getWidth()));
		base3l.setBounds(base1.getWidth()*2 - 20, master.getHeight() - base3.getHeight(), base3.getWidth(), base3.getHeight());
		base3l.setVisible(true);
		add(base3l);
		
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		BufferedImage background = null;
		try
		{
			background = ImageIO.read(new File("potato-farm.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		g.drawImage(background, 0, 0, this);

	}
	
	public BufferedImage getBL()
	{
		return base1;
	}


}
