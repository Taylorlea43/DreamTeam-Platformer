package Screens;

import java.awt.Color;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Engine.GamePanel;
import Engine.GameWindow;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Coin;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.LevelKey;
import Level.Map;
import Level.Player;
import Level.PlayerListener;
import Maps.Level1;
import Maps.Level2;
import Maps.Level3;
import Players.Cat;
import Players.Girl;
import SpriteFont.SpriteFont;
import Utils.Point;
import Utils.Stopwatch;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {

	protected ScreenCoordinator screenCoordinator;
	protected Map map;

	protected Coin coin1, coin2, coin3, coin4, coin5, coin6;
	protected LevelKey key;
	protected Player player;
	protected PlayLevelScreenState playLevelScreenState;
	protected Stopwatch screenTimer = new Stopwatch();
	protected LevelClearedScreen levelClearedScreen;
	protected LevelLoseScreen levelLoseScreen;
	protected boolean levelCompletedStateChangeStart;
	protected SpriteFont gameTimer;
	protected SpriteFont coinCounter;
	public int currLevel;
	protected int coinCount;

	protected SpriteFont healthBar;
	protected float timeElapsed;
	protected Timer timer;

	public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
		timer = new Timer();
	}

	public void initialize() {

		if (currLevel == 0) {
			// define/setup map
			this.map = new Level1();
			map.reset();
			// set up coins in the game
			this.coin1 = new Coin(320, 340);
			coin1.setBounds(new Rectangle(1, 1, 16, 16));
			coin1.setMap(map);

			this.coin2 = new Coin(620, 293);
			coin2.setBounds(new Rectangle(1, 1, 16, 16));
			coin2.setMap(map);

			this.coin3 = new Coin(865, 105);
			coin3.setBounds(new Rectangle(1, 1, 16, 16));
			coin3.setMap(map);

			this.coin4 = new Coin(1300, 130);
			coin4.setBounds(new Rectangle(1, 1, 16, 16));
			coin4.setMap(map);

			this.coin5 = new Coin(1730, 490);
			coin5.setBounds(new Rectangle(1, 1, 16, 16));
			coin5.setMap(map);

			this.coin6 = new Coin(2250, 430);
			coin6.setBounds(new Rectangle(1, 1, 16, 16));
			coin6.setMap(map);

			// setup key
			this.key = new LevelKey(955, 250, "pixelKey.png");
			key.setMap(map);

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup HUD
			TimerTick tick = new TimerTick(timer);
			timer.schedule(tick, 1000, 1000);

			timeElapsed = 0;

			this.gameTimer = new SpriteFont("Time: " + timeElapsed, 15, 50, "Comic Sans", 23, new Color(49, 207, 240)); // was 691
			this.gameTimer.setOutlineColor(Color.black);
			this.gameTimer.setOutlineThickness(3);

			this.coinCounter = new SpriteFont("Coins: " + this.getCoinCount(), 15, 75, "Comic Sans", 23, // was 694
					new Color(49, 207, 240));
			this.coinCounter.setOutlineColor(Color.black);
			this.coinCounter.setOutlineThickness(3);
			this.healthBar = new SpriteFont("Health: " + (int) player.getHealth(), 15, 25, "Comic Sans", 23,
					new Color(49, 207, 240));
			this.healthBar.setOutlineColor(Color.black);
			this.healthBar.setOutlineThickness(3);

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 1) {
			// define/setup map
			this.map = new Level2();
			map.reset();
			this.coin1 = new Coin(320, 500);
			coin1.setBounds(new Rectangle(1, 1, 16, 16));
			coin1.setMap(map);
			this.coin2 = new Coin(620, 500);
			coin2.setBounds(new Rectangle(1, 1, 16, 16));
			coin2.setMap(map);

			this.coin3 = new Coin(865, 500);
			coin3.setBounds(new Rectangle(1, 1, 16, 16));
			coin3.setMap(map);

			this.coin4 = new Coin(1300, 500);
			coin4.setBounds(new Rectangle(1, 1, 16, 16));
			coin4.setMap(map);

			this.coin5 = new Coin(1730, 500);
			coin5.setBounds(new Rectangle(1, 1, 16, 16));
			coin5.setMap(map);

			this.coin6 = new Coin(2250, 430);
			coin6.setBounds(new Rectangle(1, 1, 16, 16));
			coin6.setMap(map);

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// set up coins in the level

			// setup HUD
			TimerTick tick = new TimerTick(timer);
			timer.schedule(tick, 1000, 1000);

			timeElapsed = 0;
			this.gameTimer = new SpriteFont("Time: " + timeElapsed, 691, 25, "Comic Sans", 23, new Color(49, 207, 240));
			this.gameTimer.setOutlineColor(Color.black);
			this.gameTimer.setOutlineThickness(3);

			this.coinCounter = new SpriteFont("Coins: 0", 694, 50, "Comic Sans", 23, new Color(49, 207, 240));
			this.coinCounter.setOutlineColor(Color.black);
			this.coinCounter.setOutlineThickness(3);
			this.healthBar = new SpriteFont("Health: " + (int) player.getHealth(), 15, 25, "Comic Sans", 23,
					new Color(49, 207, 240));
			this.healthBar.setOutlineColor(Color.black);
			this.healthBar.setOutlineThickness(3);

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} 
		else if (currLevel == 2) {
			this.map = new Level3();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup HUD
			TimerTick tick = new TimerTick(timer);
			timer.schedule(tick, 1000, 1000);

			timeElapsed = 0;
			this.gameTimer = new SpriteFont("Time: " + timeElapsed, 691, 25, "Comic Sans", 23, new Color(49, 207, 240));
			this.gameTimer.setOutlineColor(Color.black);
			this.gameTimer.setOutlineThickness(3);

			this.coinCounter = new SpriteFont("Coins: 0", 694, 50, "Comic Sans", 23, new Color(49, 207, 240));
			this.coinCounter.setOutlineColor(Color.black);
			this.coinCounter.setOutlineThickness(3);
			this.healthBar = new SpriteFont("Health: " + (int) player.getHealth(), 15, 25, "Comic Sans", 23,
					new Color(49, 207, 240));
			this.healthBar.setOutlineColor(Color.black);
			this.healthBar.setOutlineThickness(3);

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		}
	}

	public void update() {
		// based on screen state, perform specific actions
		switch (playLevelScreenState) {
		// if level is "running" update player and map to keep game logic for the
		// platformer level going
		case RUNNING:
			player.update();
			map.update(player);

			coin1.check(player);
			coin2.check(player);
			coin3.check(player);
			coin4.check(player);
			coin5.check(player);
			coin6.check(player);

			key.check(player);

			healthBar.setText("Health: " + (int) player.getHealth());

			coinCounter.setText("Coins: " + this.getCoinCount());

			gameTimer.setText("Time: " + (int) timeElapsed);

			break;
			// if level has been completed, bring up level cleared screen
		case LEVEL_COMPLETED:
			if (levelCompletedStateChangeStart) {
				screenTimer.setWaitTime(2500);
				currLevel++;
				levelCompletedStateChangeStart = false;
			} else {
				levelClearedScreen.update();
//				if (screenTimer.isTimeUp()) {
//					goBackToMenu();
//				}
			}
			break;
		// wait on level lose screen to make a decision (either resets level or sends
		// player back to main menu)
		case LEVEL_LOSE:
			levelLoseScreen.update();
			break;
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		// based on screen state, draw appropriate graphics
		switch (playLevelScreenState) {
		case RUNNING:
			map.draw(graphicsHandler);
			player.draw(graphicsHandler);

			gameTimer.draw(graphicsHandler);
			coinCounter.draw(graphicsHandler);
			healthBar.draw(graphicsHandler);

			if (coin1.gotCoin == false) {
				coin1.draw(graphicsHandler);
			}
			if (coin2.gotCoin == false) {
				coin2.draw(graphicsHandler);
			}
			if (coin3.gotCoin == false) {
				coin3.draw(graphicsHandler);
			}
			if (coin4.gotCoin == false) {
				coin4.draw(graphicsHandler);
			}
			if (coin5.gotCoin == false) {
				coin5.draw(graphicsHandler);
			}
			if (coin6.gotCoin == false) {
				coin6.draw(graphicsHandler);
			}

			if (key.gotKey == false) {
				key.draw(graphicsHandler);
			}

			break;
		case LEVEL_COMPLETED:
			levelClearedScreen.draw(graphicsHandler);

			break;
		case LEVEL_LOSE:
			levelLoseScreen.draw(graphicsHandler);
			break;
		}
	}

	public void goBackToMenu() {
		screenCoordinator.setGameState(GameState.MENU);
	}

	public class TimerTick extends TimerTask {
		protected Timer timer;

		public TimerTick(Timer timer) {
			this.timer = timer;
		}

		public void run() {
			if (screenCoordinator.getGameState().equals(GameState.LEVEL))
				timeElapsed += 1;
			if (playLevelScreenState == PlayLevelScreenState.LEVEL_LOSE) {
				this.cancel();
			}

		}
	}

	public PlayLevelScreenState getPlayLevelScreenState() {
		return playLevelScreenState;
	}

	@Override
	public void onLevelCompleted() {
		if (playLevelScreenState != PlayLevelScreenState.LEVEL_COMPLETED) {
			playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
			levelCompletedStateChangeStart = true;
		}
	}

	@Override
	public void onDeath() {
		if (playLevelScreenState != PlayLevelScreenState.LEVEL_LOSE) {
			playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
			//timer.cancel();
		}
	}

	public void resetLevel() {
		initialize();
	}

	public void loadNextLevel() {
		initialize();
	}

	// This enum represents the different states this screen can be in
	private enum PlayLevelScreenState {
		RUNNING, LEVEL_COMPLETED, LEVEL_LOSE
	}

	public int getCoinCount() {
		coinCount = coin1.getCoinCount() + coin2.getCoinCount() + coin3.getCoinCount() + coin4.getCoinCount()
				+ coin5.getCoinCount() + coin6.getCoinCount();
		return coinCount;
	}
}
