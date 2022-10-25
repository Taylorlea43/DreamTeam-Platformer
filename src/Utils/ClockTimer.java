package Utils;

import javax.swing.Timer;
import Game.GameState;
import Screens.PlayLevelScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockTimer extends Timer
{
	protected PlayLevelScreen level;
	
	public ClockTimer(PlayLevelScreen screen)
	{
		super(1000, null);
		level = screen;
		this.addActionListener(new ClockListener());
	}
	
	public void toggle()
	{
		if (this.isRunning())
			this.stop();
		else
			this.start();
	}
	
	private class ClockListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (level.screenCoordinator.getGameState().equals(GameState.LEVEL))
				level.timeElapsed += 1;
			if (level.player.isDead())
			{
				level.timer.stop();
			}
		}
	}
}

