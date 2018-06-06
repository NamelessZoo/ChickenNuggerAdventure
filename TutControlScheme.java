import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TutControlScheme implements KeyListener
{
	private Tutorial tut;
	private MasterFrame master;
	
	public TutControlScheme(Tutorial jimmy, MasterFrame jammer)
	{
		tut = jimmy;
		master = jammer;
	}

	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == e.VK_W)
		{
			if(!tut.getCont1())
				tut.setTutInfo("Now try to shoot using the space key!");
			master.getPlayer().jumping();
			tut.setCont1(true);
		}
		if(e.getKeyCode() == e.VK_A)
		{
			if(!tut.getCont1())
				tut.setTutInfo("Now try to shoot using the space key!");
			master.getPlayer().setDX(-10);
			tut.setCont1(true);
		}
		if(e.getKeyCode() == e.VK_S)
		{
			if(!tut.getCont1())
				tut.setTutInfo("Now try to shoot using the space key!");
			tut.setCont1(true);
		}
		if(e.getKeyCode() == e.VK_D)
		{
			if(!tut.getCont1())
				tut.setTutInfo("Now try to shoot using the space key!");
			master.getPlayer().setDX(10);
			tut.setCont1(true);
		}
		if(e.getKeyCode() == e.VK_SPACE)
		{
			if(!tut.getCont2())
				tut.setTutInfo("Great! Use the Q key to punch!");
			tut.setCont2(true);
		}
		if(e.getKeyCode() == e.VK_Q)
		{
			if(!tut.getCont3())
			{
				tut.setTutInfo("Awesome! Now, press R to go into super mode when you have a full ketchup meter!");
			}
			
			tut.setCont3(true);
		}
		if(e.getKeyCode() == e.VK_R)
		{
			if(!tut.getCont4())
				tut.setTutInfo("Absolutely radical bro! You have completed the tutorial. Now you are ready to start the game. Press enter to continue.");
			tut.setCont4(true);
		}
		if(e.getKeyCode() == e.VK_ENTER)
		{
			
			master.removeKeyListener(this);
			master.pttoFrmCtrlSchm();
//			master.getTutorial().remove(master.getTutorial().getPlayer());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == e.VK_A)
		{

			master.getPlayer().setDX(0);
		}
		if(e.getKeyCode() == e.VK_D)
		{
			master.getPlayer().setDX(0);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
}
