import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TestFrame extends JFrame implements ActionListener
{
	private ChickenNugger test;
	
	public TestFrame()
	{
		setBounds(100,100,600,400);
		test = new ChickenNugger(0,0);
		setLayout(null);
		add(test);
		Timer timer = new Timer(10,this);
		timer.start();
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE)
					test.setDY(-2);
				if (e.getKeyCode() == KeyEvent.VK_A)
					test.setDX(-2);
				if (e.getKeyCode() == KeyEvent.VK_D)
					test.setDX(2);
			}
			
			public void keyReleased(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_W)
					test.setDY(0);
				if (e.getKeyCode() == KeyEvent.VK_S)
					test.setDY(0);
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
		repaint();
	}
}
