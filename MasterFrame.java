import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MasterFrame extends JFrame implements ActionListener
{
	//fields
	private int scurt = 2;
	private JPanel current;
	private double ssw = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double ssh = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	private double framew;
	private double frameh;
	private Tutorial tut;
	private Timer timer;
	private TutControlScheme tcs;
	private PttoFrmCtrl pfc;
	private PotatoFarmLvl pfl;
	private ChickenNugger player;
	
	
	public MasterFrame() 
	{
		
		timer = new Timer(10, this);
		
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		framew = getWidth();
		frameh = getHeight();
		current = new Tutorial(this);
		tut = (Tutorial)current;
		add(current);
		player = tut.getPlayer();
		pfl = new PotatoFarmLvl(this);

		
		timer.start();
		tcs = new TutControlScheme(tut, this);
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			
		}
		tut.setTutInfo("Try moving around! Use the WASD keys to move! (Press enter to skip tutorial)");
		addKeyListener(tcs);
		
	}
	
	public double retHeight()
	{
		return frameh;
	}
	public double retWidth()
	{
		return framew;
	}
	
	public void changeState(Boolean meanie)
	{
		meanie = true;
	}
	
	public static void main(String[] args) 
	{
		new MasterFrame();
	}
	public void actionPerformed(ActionEvent e) 
	{
		player.update();
		repaint();
	}
	public void pttoFrmCtrlSchm()
	{
		add(player);
		player.setLocation(0, getHeight() - pfl.getBL().getHeight() - player.getHeight() + 1);
		tut.setVisible(false);
		pfc = new PttoFrmCtrl(pfl, this);
		addKeyListener(pfc);
		pfl = new PotatoFarmLvl(this);
		current = pfl;
		add(pfl);
		pfl.setVisible(true);

	}
	
	public JPanel getCurr()
	{
		return current;
	}
	public PotatoFarmLvl getPfl()
	{
		return pfl;
	}
	public ChickenNugger getPlayer()
	{
		return player;
	}
	
	public Tutorial getTutorial()
	{
		return tut;
	}
}
