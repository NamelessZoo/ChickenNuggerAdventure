import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PttoFrmCtrl implements KeyListener
{
	private PotatoFarmLvl pfl;
	private MasterFrame master;
	private ChickenNugger player;
	
	public PttoFrmCtrl(PotatoFarmLvl jimmy, MasterFrame jammer)
	{
		pfl = jimmy;
		master = jammer;
		player = master.getPlayer();
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == e.VK_ENTER)
		{
			master.getCurr().setVisible(false);
			master.getPfl().setVisible(true);
		}
		if(e.getKeyCode() == e.VK_W)
		{
			player.jumping();
		}
		if(e.getKeyCode() == e.VK_A)
		{
			player.setDX(-10);
		}
		if(e.getKeyCode() == e.VK_S)
		{
			
		}
		if(e.getKeyCode() == e.VK_D)
		{
			player.setDX(10);
		}
		if(e.getKeyCode() == e.VK_SPACE)
		{
			
		}
		if(e.getKeyCode() == e.VK_Q)
		{
			
		}
		if(e.getKeyCode() == e.VK_R)
		{
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == e.VK_A)
		{
			player.setDX(0);
		}
		if(e.getKeyCode() == e.VK_D)
		{
			player.setDX(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
}
