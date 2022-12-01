package Screens;

import java.awt.*;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.AvatarMap;
import Maps.TitleScreenMap;
import Sounds.AudioPlayer;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

public class AvatarScreen extends Screen
{
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected int avatarSelection = 1;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
	protected Stopwatch keyTimer = new Stopwatch();
    protected SpriteFont returnInstructionsLabel, avatarLabel, boyLabel, girlLabel;
    
	public AvatarScreen(ScreenCoordinator screenCoordinator) 
	{
		this.screenCoordinator = screenCoordinator;
		
		initialize();
	}

	@Override
	public void initialize() 
	{   
		background = new AvatarMap();
        background.setAdjustCamera(false);
        keyTimer.setWaitTime(200);
		
		avatarLabel = new SpriteFont("CHOOSE YOUR AVATAR!", 575, 150, "Comic Sans", 30, Color.black);      
        
        keyLocker.lockKey(Key.SPACE);
	}

	@Override
	public void update() {
        background.update(null);
        
        if (Keyboard.isKeyDown(Key.LEFT) && keyTimer.isTimeUp()) {
			keyTimer.reset();
			avatarSelection++;
		} else if (Keyboard.isKeyDown(Key.RIGHT) && keyTimer.isTimeUp()) {
			keyTimer.reset();
			avatarSelection--;
		}

		// if down is pressed on last menu item or up is pressed on first menu item,
		// "loop" the selection back around to the beginning/end
		if (avatarSelection > 2) {
			avatarSelection = 1;
		} else if (avatarSelection < 1) {
			avatarSelection = 2;
		}
		
		if (avatarSelection == 1)
		{
			pointerLocationX = 633;
			pointerLocationY = 300;
		}
		
		else if (avatarSelection == 2)
		{
			pointerLocationX = 832;
			pointerLocationY = 300;
		}
		
		if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) 
        {
        	try {
				AudioPlayer startEffect = new AudioPlayer(false, "Resources/GameStart_Sound.wav");
				startEffect.play();
			}

			catch (Exception e) {
				System.out.println("Error with sound");
			}
        	
        	screenCoordinator.setGameState(GameState.MENU);
        	ScreenCoordinator.avatarSelection = avatarSelection;
            MenuScreen.musicAlreadyPlaying = true;            
        }
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler)
	{	
		//graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
			//	Color.black);
		background.draw(graphicsHandler);
		avatarLabel.draw(graphicsHandler);
		
		graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20,
				new Color(49, 207, 240), Color.black, 2);

	}

}
