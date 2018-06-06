import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public abstract class Item extends JComponent
{
	public Item (int x, int y)
	{
		setLocation(x,y);
	}
	
	public abstract Rectangle2D getRect();
	
	public abstract void effect(ChickenNugger a);
}
