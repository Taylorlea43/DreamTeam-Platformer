package Screens;

import java.awt.*;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

public class InstructionScreen extends Screen
{
	protected ScreenCoordinator screenCoordinator;
	protected KeyLocker keyLocker = new KeyLocker();
	protected SpriteFont instructions, controls, quit, pause, select;
	
	public InstructionScreen(ScreenCoordinator screenCoordinator)
	{
		this.screenCoordinator = screenCoordinator;
		
		initialize();
	}
	
	@Override
	public void initialize()
	{
		instructions = new SpriteFont("Instructions", Config.GAME_WINDOW_WIDTH/2-120, 200, "Comic Sans", 45, Color.white);
		controls = new SpriteFont("Controls: Use the arrow keys to move player. Left and right arrows for movement and up arrow to jump.", 115, 300, "Comic Sans", 25, Color.white);
		quit = new SpriteFont("Quit: Press 'Command Q' to exit the game at any time.", 115, 360, "Comic Sans", 25, Color.white);
		pause = new SpriteFont("Pause: Press 'P' to pause the game at any time.", 115, 420, "Comic Sans", 25, Color.white);
		select = new SpriteFont("Space: Use the space bar to make selections and return", 115, 480, "Comic Sans", 25, Color.white);
		// ("message", x location, y location, "font", size, color)
		
		keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);
	}

	@Override
	public void update() 
	{
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

        instructions.draw(graphicsHandler);
        controls.draw(graphicsHandler);
        quit.draw(graphicsHandler);
        pause.draw(graphicsHandler);
        select.draw(graphicsHandler);
	}

}
