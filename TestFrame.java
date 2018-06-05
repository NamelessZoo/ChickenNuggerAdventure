import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TestFrame extends JFrame implements ActionListener
{
	private ChickenNugger test;
	private FrenchFriedMinion french;
	private Bullet ball;
	private ArrayList<Bullet> balls;
	private Bars bar;
	private HireWireJugggler juggler;
	private SweerPotatoMinion sweet;
	
	public TestFrame()
	{
		setBounds(0,0,1920,1080);
		test = new ChickenNugger(0,200);
		french = new FrenchFriedMinion(1000,156);
		bar = new Bars();
		balls = new ArrayList<Bullet>();
		juggler = new HireWireJugggler(500,250);
		sweet = new SweerPotatoMinion(1100,156);
		setLayout(null);
		add(test);
		add(french);
		add(bar);
		add(juggler);
		add(sweet);
		Timer timer = new Timer(10,this);
		timer.start();
		juggler.animate();
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE)
					test.jumping(200);
				if (e.getKeyCode() == KeyEvent.VK_A)
					test.setDX(-3);
				if (e.getKeyCode() == KeyEvent.VK_D)
					test.setDX(3);
				if (e.getKeyCode() == KeyEvent.VK_S)
					test.superMode();
				if (e.getKeyCode() == KeyEvent.VK_W)
					test.punching();
				if (e.getKeyCode() == KeyEvent.VK_R)
					test.spGain(50);
				if (e.getKeyCode() == KeyEvent.VK_C)
					test.healed(10);
				if (e.getKeyCode() == KeyEvent.VK_X)
					french.setHP(0);
				if (e.getKeyCode() == KeyEvent.VK_G)
					test.shooting();
				if (e.getKeyCode() == KeyEvent.VK_T){
					if(ChickenNugger.isShooting()){
						ball = new Bullet(test.getX()+test.getWidth(), (test.getY() + 100));
						balls.add(ball);
						add(ball);
						if(!ChickenNugger.isLeft()) {
							ball.setDX(+10);
						}
						if(ChickenNugger.isLeft()) {
							ball.setDX(-10);
						}
						Bars.setAmmo(Bars.getAmmo() - 1);
					}
				}
					
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
		french.update();
		juggler.update();
		sweet.update();
		test.contact(french, 10, 15);
		test.contact(sweet, 15, 15);
		for(int i = 0; i<balls.size(); i++) 
		{
			balls.get(i).update();
			balls.get(i).damage(french);
			balls.get(i).damage(sweet);
			if(balls.get(i).getX() > getWidth() || balls.get(i).getX() < 0 || balls.get(i).getY() < 0 || balls.get(i).getY() > getHeight()) 
			{
				remove(balls.get(i));
				balls.remove(balls.get(i));
			}
		}
		repaint();
	}
}
