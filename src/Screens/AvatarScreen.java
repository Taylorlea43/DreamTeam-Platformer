package Screens;

import java.awt.*;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

public class AvatarScreen extends Screen
{
    protected ScreenCoordinator screenCoordinator;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont returnInstructionsLabel, avatarLabel, boyLabel, girlLabel;
    
	public AvatarScreen(ScreenCoordinator screenCoordinator) 
	{
		this.screenCoordinator = screenCoordinator;
		
		initialize();
	}

	@Override
	public void initialize() 
	{   
        avatarLabel = new SpriteFont("CHOOSE YOUR AVATAR", 175, 100, "Times New Roman", 60, Color.white);      
        boyLabel = new SpriteFont("BOY", 175, 175, "Times New Roman", 30, Color.white);
        girlLabel = new SpriteFont("GIRL", 175, 215, "Times New Roman", 30, Color.white);

        
        keyLocker.lockKey(Key.SPACE);
	}

	@Override
	public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
            MenuScreen.musicAlreadyPlaying = true;
        }
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler)
	{	
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
				Color.black);
		avatarLabel.draw(graphicsHandler);
		boyLabel.draw(graphicsHandler);	
		girlLabel.draw(graphicsHandler);	

	}

}
