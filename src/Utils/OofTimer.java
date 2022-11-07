package Utils;

import javax.swing.Timer;
import Level.Player;
import Screens.PlayLevelScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OofTimer extends Timer
{
	public Player player;
	public PlayLevelScreen level;
	
	public OofTimer(Player player, PlayLevelScreen level)
	{
		super (125, null);
		
		this.player = player;
		this.level = level;
		
		this.addActionListener(new OofListener());	
	}
	
	private class OofListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			try 
			{
				this.wait(250);
			} 
			
			catch (InterruptedException ex) 
			{
				ex.printStackTrace();
			}
		}
	}
}