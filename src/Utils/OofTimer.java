package Utils;

import javax.swing.Timer;
import Level.Player;
import Screens.PlayLevelScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OofTimer extends Timer
{
	public Player player;
	
	public OofTimer(Player player)
	{
		super (500, null);	
		this.player = player;
		this.addActionListener(new OofListener());	
	}
	
	public void reset()
	{
		player.isInvincible = false;
		this.stop();
	}
	
	private class OofListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			player.isInvincible = false;
		}
	}
}