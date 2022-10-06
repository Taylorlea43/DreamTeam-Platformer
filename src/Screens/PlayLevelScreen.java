package Screens;

import java.awt.Color;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Coin;
import GameObject.Frame;
import GameObject.GameObject;
import Level.Map;
import Level.Player;
import Level.PlayerListener;
import Maps.Level1;
import Maps.Level2;
import Maps.Level3;
import Players.Cat;
import SpriteFont.SpriteFont;
import Utils.Point;
import Utils.Stopwatch;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {

	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Coin coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10;
	protected GameObject key;
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

	public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}

	public void initialize() {

		if (currLevel == 0) {
			// define/setup map
			this.map = new Level1();
			map.reset();

			// set up coins in the game
			this.coin1 = new Coin(630, 380, "coin.png");
			coin1.setMap(map);

			this.coin2 = new Coin(320, 300, "coin.png");
			coin2.setMap(map);

			this.coin3 = new Coin(865, 105, "coin.png");
			coin3.setMap(map);

			this.coin4 = new Coin(1300, 100, "coin.png");
			coin4.setMap(map);

			this.coin5 = new Coin(1775, 110, "coin.png");
			coin5.setMap(map);

			this.coin6 = new Coin(2250, 430, "coin.png");
			coin6.setMap(map);

			// setup key
			Frame frame1 = new Frame(ImageLoader.load("key.png"));
			this.key = new GameObject(1025, 250, frame1);
			key.setMap(map);

			this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup HUD
			Timer timer = new Timer();
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
		} else if (currLevel == 1)

		{
			// define/setup map
			this.map = new Level2();
			map.reset();
			this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;
			
			//set up coins in the level 
			

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} else if (currLevel == 2) {
			this.map = new Level3();
			map.reset();

			this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

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

			healthBar.setText("Health: " + (int) player.getHealth());

			coinCounter.setText("Coins " + this.getCoinCount());

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

			key.draw(graphicsHandler);

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
			else if (playLevelScreenState == PlayLevelScreenState.LEVEL_LOSE) {
				timer.cancel();
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
