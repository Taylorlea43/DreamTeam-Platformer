package Engine;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

/*
 * The JFrame that holds the GamePanel
 * Just does some setup and exposes the gamePanel's screenManager to allow an external class to setup their own content and attach it to this engine.
 */
public class GameWindow {
	public static JFrame gameWindow;
	private GamePanel gamePanel;
	private final Key FULLSCREEN_KEY = Key.F;
	private boolean isGameFullscreen = false;

	private KeyLocker keyLocker = new KeyLocker();

	public GameWindow() {

		gameWindow = new JFrame("Game");
		gamePanel = new GamePanel();

		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();

		gameWindow.setContentPane(gamePanel);
		gameWindow.setResizable(false);
		gameWindow.setUndecorated(false);

		gameWindow.setSize(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT);

		gameWindow.setLocationRelativeTo(null);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it'd be nice if this actually worked more than
																	// 1/3rd of the time
		gamePanel.setupGame();

//		updateFullscreen();

//		if (!isGameFullscreen) {
//			gameWindow.setSize(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT);
//		}
//		if (isGameFullscreen) {
//
//			gameWindow.setSize(Config.FULL_GAME_WINDOW_WIDTH, Config.FULL_GAME_WINDOW_HEIGHT);
//		}

	}

	public void updateFullscreen() {
		if (Keyboard.isKeyDown(FULLSCREEN_KEY) && !keyLocker.isKeyLocked(FULLSCREEN_KEY)) {
			isGameFullscreen = !isGameFullscreen;
			keyLocker.lockKey(FULLSCREEN_KEY);

		}

		if (Keyboard.isKeyUp(FULLSCREEN_KEY)) {
			keyLocker.unlockKey(FULLSCREEN_KEY);
		}
	}

	// triggers the game loop to start as defined in the GamePanel class
	public void startGame() {
		gamePanel.startGame();
	}

	public ScreenManager getScreenManager() {
		return gamePanel.getScreenManager();
	}
}
