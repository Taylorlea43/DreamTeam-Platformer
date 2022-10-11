package Screens;

import Engine.*;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the level lose screen
public class LevelLoseScreen extends Screen {
	protected SpriteFont loseMessage;
	protected SpriteFont instructions;
	protected SpriteFont instructions2;

	protected KeyLocker keyLocker = new KeyLocker();
	protected PlayLevelScreen playLevelScreen;
	public int commandInput;

	public LevelLoseScreen(PlayLevelScreen playLevelScreen) {
		this.playLevelScreen = playLevelScreen;
		initialize();
	}

	public void GameOver(int keyLocker) {

	}

	@Override
	public void initialize() {
		loseMessage = new SpriteFont("GAME OVER", 350, 270, "Comic Sans", 30, Color.white);
		instructions = new SpriteFont("RETRY", 120, 300, "Comic Sans", 20, Color.white);
		instructions2 = new SpriteFont("QUIT", 120, 400, "Comic Sans", 20, Color.white);
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

//		 if space is pressed, reset level. if escape is pressed, go back to main menu
		if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE) && commandInput == 0) {
			playLevelScreen.resetLevel();
		} else if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE) && commandInput == 1) {
			playLevelScreen.goBackToMenu();
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
				Color.black);
		loseMessage.draw(graphicsHandler);
		instructions.draw(graphicsHandler);
		instructions2.draw(graphicsHandler);
		if (Keyboard.isKeyDown(Key.DOWN)) {
			commandInput = 1;
			playLevelScreen.update();
			

		} else if (Keyboard.isKeyDown(Key.UP)) {
			commandInput = 0;
			playLevelScreen.update();
			

		}
		if (commandInput == 0) {
			graphicsHandler.drawString(">", 100, 300, null, Color.white);
		} else if (commandInput == 1) {
			graphicsHandler.drawString(">", 100, 400, null, Color.white);

		}
	}
}
