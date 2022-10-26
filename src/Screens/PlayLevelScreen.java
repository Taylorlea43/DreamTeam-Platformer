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
import Maps.*;
import Players.Cat;
import Players.Girl;
import SpriteFont.SpriteFont;
import Utils.ClockTimer;
import Utils.Point;
import Utils.Stopwatch;
import Sounds.AudioPlayer;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {

	public ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Coin coin1, coin2, coin3, coin4, coin5, coin6;
	protected LevelKey key;
	public Player player;
	public PlayLevelScreenState playLevelScreenState;
	protected Stopwatch screenTimer = new Stopwatch();
	protected LevelClearedScreen levelClearedScreen;
	protected LevelLoseScreen levelLoseScreen;
	protected boolean levelCompletedStateChangeStart;
	protected SpriteFont gameTimer;
	protected SpriteFont coinCounter;
	protected SpriteFont keyStatusBar, keyStatus;
	public int currLevel;
	protected int coinCount;
	protected AudioPlayer levelMusic;

	protected SpriteFont healthBar;
	public int timeElapsed;
	public ClockTimer timer;

	public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
		timer = new ClockTimer(this);
	}

	public void initialize() {

		if (currLevel == 0) {
			// define/setup map
			this.map = new TestMap();
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
			
			//set up key status
			this.keyStatusBar = new SpriteFont("Key: ", 15, 100, "Comic Sans", 23, new Color(49, 207, 240));
			this.keyStatusBar.setOutlineColor(Color.black);
			this.keyStatusBar.setOutlineThickness(3);
			
			this.keyStatus = new SpriteFont(" ", 75, 100, "Comic Sans", 23, new Color(250, 204, 77));
			this.keyStatus.setOutlineColor(Color.black);
			this.keyStatus.setOutlineThickness(3);
			
			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
			
			
			//setup player

			this.key = new LevelKey(955, 250, "pixelKey.png");
			key.setMap(map);

//			this.displayKey = new LevelKey(7, 65, "pixelKey.png");
//			displayKey.setMap(map);


			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup AudioPlayer
			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			// setup HUD
			timeElapsed = 0;
			timer.start();

			this.gameTimer = new SpriteFont("Time: " + timeElapsed, 15, 50, "Comic Sans", 23, new Color(49, 207, 240)); // was 691
			this.gameTimer.setOutlineColor(Color.black);
			this.gameTimer.setOutlineThickness(3);

			this.coinCounter = new SpriteFont("Coins: " + this.getCoinCount(), 15, 75, "Comic Sans", 23, // was 694
					new Color(49, 207, 240));
			this.coinCounter.setOutlineColor(Color.black);
			this.coinCounter.setOutlineThickness(3);

			this.healthBar = new SpriteFont("Health: " + (int) player.getHealth(), 15, 25, "Comic Sans", 23, new Color(49, 207, 240));
			this.healthBar.setOutlineColor(Color.black);
			this.healthBar.setOutlineThickness(3);

		} 
		
		else if (currLevel == 1) 
			
		{


			this.keyStatusBar = new SpriteFont("Key: ", 15, 100, "Comic Sans", 23, new Color(49, 207, 240));
			this.keyStatusBar.setOutlineColor(Color.black);
			this.keyStatusBar.setOutlineThickness(3);

			//setup key status
			this.keyStatus = new SpriteFont(" ", 75, 100, "Comic Sans", 23, new Color(250, 204, 77));
			this.keyStatus.setOutlineColor(Color.black);
			this.keyStatus.setOutlineThickness(3);

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} else if (currLevel == 1) {

			// define/setup map
			this.map = new Level1();
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

			this.key = new LevelKey(955, 450, "pixelKey.png");
			key.setMap(map);
			
			key = new LevelKey(955, 250, "pixelKey.png");
			key.setMap(map);

			this.key = new LevelKey(955, 450, "pixelKey.png");
			key.setMap(map);


			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} else if (currLevel == 2) {

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

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 3) {
			this.map = new Level3();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}


			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 4) {
			this.map = new Level4();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		}else if (currLevel == 5) {
			this.map = new Level5();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		}else if (currLevel == 6) {
			this.map = new Level6();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}


			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		}else if (currLevel == 7) {
			this.map = new Level7();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		}else if (currLevel == 8) {
			this.map = new Level8();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		}else if (currLevel == 9 ){
			this.map = new Level9();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}


			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		}else if (currLevel == 10) {
			this.map = new Level10();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}


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
			
			keyStatusBar.setText("Key: ");
			
			if (key.gotKey == false) 
			{
				keyStatus.setText("KEY NEEDED");
			} else {
				keyStatus.setText("You have the key!");
			}
			
			

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
		case LEVEL_LOSE:{
			levelLoseScreen.update();
			break;
			}
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
			keyStatusBar.draw(graphicsHandler);
			keyStatus.draw(graphicsHandler);

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

			if (key.gotKey == false) 
			{
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

	public PlayLevelScreenState getPlayLevelScreenState() {
		return playLevelScreenState;
	}

	@Override
	public void onLevelCompleted() {
		if (playLevelScreenState != PlayLevelScreenState.LEVEL_COMPLETED) {
			playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
			levelCompletedStateChangeStart = true;
			
			try
			{
				levelMusic.stop();
			}
			
			catch(Exception e)
			{
			}
		}
	}

	@Override
	public void onDeath() {
		if (playLevelScreenState != PlayLevelScreenState.LEVEL_LOSE) {
			playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;

			try
			{
				levelMusic.stop();
			}

			catch(Exception e)
			{
			}
		}
	}
	
	public boolean playerLose()
	{
		return (playLevelScreenState == PlayLevelScreenState.LEVEL_LOSE);			
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
