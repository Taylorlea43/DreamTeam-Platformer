package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Screens.PlayLevelScreen;
import Level.Map;
import Maps.GameCompleteMap;
import Maps.TitleScreenMap;

public class GameWonScreen extends Screen {
	protected KeyLocker keyLocker = new KeyLocker();
	protected ScreenCoordinator screenCoordinator;
	private PlayLevelScreen playLevelScreen;
	protected Map background;

	public GameWonScreen(PlayLevelScreen playLevelScreen) {

		this.playLevelScreen = playLevelScreen;
		initialize();
	}

	@Override
	public void initialize() {
		background = new GameCompleteMap();
		background.setAdjustCamera(false);
	}

	@Override
	public void update() {
		background.update(null);
		if (Keyboard.isKeyUp(Key.ESC)) {
			keyLocker.unlockKey(Key.ESC);
		}
		if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {
			playLevelScreen.goBackToMenu();
			MenuScreen.musicAlreadyPlaying = true;
		}
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		background.draw(graphicsHandler);
	}
}
