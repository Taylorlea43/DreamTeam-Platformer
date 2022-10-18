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
	protected Key FULLSCREEN_KEY = Key.F;

	public GameWindow() {

		gameWindow = new JFrame("Game");
		gamePanel = new GamePanel();

		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();

		gameWindow.setContentPane(gamePanel);
		gameWindow.setResizable(false);
		gameWindow.setUndecorated(false);

		gameWindow.setSize(Config.FULL_GAME_WINDOW_WIDTH, Config.FULL_GAME_WINDOW_HEIGHT);
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it'd be nice if this actually worked more than
																	// 1/3rd of the time
		gamePanel.setupGame();
	}

	// triggers the game loop to start as defined in the GamePanel class
	public void startGame() {
		gamePanel.startGame();
	}

	public ScreenManager getScreenManager() {
		return gamePanel.getScreenManager();
	}
}
