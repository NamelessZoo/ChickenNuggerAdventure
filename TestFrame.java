import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TestFrame extends JFrame implements ActionListener
{
	private ChickenNugger test;
	private FrenchFriedMinion minion;
	private ArrayList<Bullet> balls;
	private Bars bar;
	
	public TestFrame()
	{
		setBounds(0,0,1920,1080);
		test = new ChickenNugger(0,200);
		minion = new FrenchFriedMinion(1000,156);
		bar = new Bars();
		setLayout(null);
		add(test);
		add(minion);
		add(bar);
		Timer timer = new Timer(10,this);
		timer.start();
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE)
					test.jumping();
				if (e.getKeyCode() == KeyEvent.VK_A)
					test.setDX(-3);
				if (e.getKeyCode() == KeyEvent.VK_D)
					test.setDX(3);
				if (e.getKeyCode() == KeyEvent.VK_S)
					test.superMode();
				if (e.getKeyCode() == KeyEvent.VK_W)
					test.punching();
				if (e.getKeyCode() == KeyEvent.VK_F)
					test.damaged(20);
				if (e.getKeyCode() == KeyEvent.VK_R)
					test.spGain(50);
				if (e.getKeyCode() == KeyEvent.VK_C)
					test.healed(10);
				if (e.getKeyCode() == KeyEvent.VK_X)
					minion.setHP(0);
			}
			
			public void keyReleased(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_A)
					test.setDX(0);
				if (e.getKeyCode() == KeyEvent.VK_D)
					test.setDX(0);
			}

			public void keyTyped(KeyEvent e) 
			{
				
			}
		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new TestFrame();
	}

	public void actionPerformed(ActionEvent arg0)
	{
		test.update();
		minion.update();
		if(balls.get(i).getX() > getWidth() || balls.get(i).getX() < 0 || balls.get(i).getY() < 0 || balls.get(i).getY() > getHeight()) {
				remove(balls.get(i));
				balls.remove(balls.get(i));
		}
		repaint();
	}
}
