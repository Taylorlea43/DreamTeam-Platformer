package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the level cleared screen
public class LevelClearedScreen extends Screen {
	protected SpriteFont winMessage;
	protected SpriteFont instructions;
	protected KeyLocker keyLocker = new KeyLocker();
	protected PlayLevelScreen playLevelScreen;

	public LevelClearedScreen(PlayLevelScreen playLevelScreen) {
		this.playLevelScreen = playLevelScreen;

		initialize();
	}

	@Override
	public void initialize() {
		winMessage = new SpriteFont("Level Cleared", 320, 270, "Comic Sans", 30, Color.white);
		instructions = new SpriteFont("Press Space to go to the next Level or Escape to go back to the Main Menu", 120, 300, "Comic Sans", 20, Color.white);
		keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);  

	}

	@Override
	public void update() {
		if (Keyboard.isKeyUp(Key.SPACE)) {
			keyLocker.unlockKey(Key.SPACE);
		}
		if (Keyboard.isKeyUp(Key.ESC)) {
			keyLocker.unlockKey(Key.ESC);
		}

		// if space is pressed, reset level. if escape is pressed, go back to main menu
		if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
			playLevelScreen.resetLevel();
		} else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
			playLevelScreen.goBackToMenu();
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		// paint entire screen black and dislpay level cleared text
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
				Color.black);
		winMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);

	}
}
