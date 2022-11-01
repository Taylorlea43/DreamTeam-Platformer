package Utils;

import javax.swing.Timer;
import Screens.PlayLevelScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlinkTimer extends Timer
{
	public PlayLevelScreen level;
	
	
	public BlinkTimer(PlayLevelScreen s)
	{
		super (125, null);
		level = s;
		this.addActionListener(new BlinkListener());
	}
	
	public void healthReset()
	{
		level.blink = false;
		this.stop();
	}
	
	private class BlinkListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!level.blink)
				level.blink = true;
				else
					level.blink = false;
		}
	}
}
