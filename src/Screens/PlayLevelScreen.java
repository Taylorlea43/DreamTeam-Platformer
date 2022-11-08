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
import Players.Boy;
import Players.Cat;
import Players.Girl;
import SpriteFont.SpriteFont;
import Utils.BlinkTimer;
import Utils.ClockTimer;
import Utils.Point;
import Utils.Stopwatch;
import Sounds.AudioPlayer;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {

	public ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Coin coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10, coin11, coin12, coin13, coin14, coin15, coin16, coin17, coin18, coin19, coin20, coin21, coin22, coin23, coin24, coin25, coin26, coin27, coin28, coin29, coin30, coin31, coin32, coin33, coin34, coin35, coin36, coin37, coin38, coin39, coin40, coin41, coin42, coin43, coin44, coin45, coin46, coin47, coin48, coin49, coin50, coin51, coin52, coin53, coin54, coin55;
	protected LevelKey key;
	public Player player;
	public PlayLevelScreenState playLevelScreenState;
	protected Stopwatch screenTimer = new Stopwatch();
	protected LevelClearedScreen levelClearedScreen;
	protected LevelLoseScreen levelLoseScreen;
	protected GameWonScreen gameWonScreen;
	protected boolean levelCompletedStateChangeStart;
	protected SpriteFont gameTimer;
	protected SpriteFont coinCounter;
	protected SpriteFont keyStatusBar, keyStatus;
	public int currLevel;
	protected int coinCount0, coinCount1, coinCount, coinCount2, coinCount3, coinCount4, coinCount5, coinCount6, coinCount7, coinCount8, coinCount9, coinCount10;
	protected AudioPlayer levelMusic;
	public boolean blink = false;
	public boolean oof = false;
	protected BlinkTimer blinkTimer;
	protected SpriteFont healthBar;
	public int timeElapsed;
	public ClockTimer timer;

	public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
		timer = new ClockTimer(this);
		blinkTimer = new BlinkTimer(this);
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


			// setup key
			this.key = new LevelKey(955, 250, "pixelKey.png");
			key.setBounds(new Rectangle(30, 25, 25, 20));
			key.setMap(map);

			// setup player
			this.player = new Boy(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);	//changes girl or boy
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

			this.gameTimer = new SpriteFont("Time: " + timeElapsed, 15, 50, "Comic Sans", 23, new Color(49, 207, 240)); // was
			// 691
			this.gameTimer.setOutlineColor(Color.black);
			this.gameTimer.setOutlineThickness(3);

			this.coinCounter = new SpriteFont("Coins: " + this.getCoinCount(), 15, 75, "Comic Sans", 23, // was 694
					new Color(49, 207, 240));
			this.coinCounter.setOutlineColor(Color.black);
			this.coinCounter.setOutlineThickness(3);

			this.healthBar = new SpriteFont("Health: " + (int) player.getHealth(), 15, 25, "Comic Sans", 23,
					new Color(49, 207, 240));
			this.healthBar = new SpriteFont("Health: " + (int) player.getHealth(), 15, 25, "Comic Sans", 23,
					new Color(49, 207, 240));
			this.healthBar.setOutlineColor(Color.black);
			this.healthBar.setOutlineThickness(3);

			this.keyStatusBar = new SpriteFont("Key: ", 15, 100, "Comic Sans", 23, new Color(49, 207, 240));
			this.keyStatusBar.setOutlineColor(Color.black);
			this.keyStatusBar.setOutlineThickness(3);

			// setup key status
			this.keyStatus = new SpriteFont(" ", 75, 100, "Comic Sans", 23, new Color(250, 204, 77));
			this.keyStatus.setOutlineColor(Color.black);
			this.keyStatus.setOutlineThickness(3);

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} else if (currLevel == 1) {
			timeElapsed = 0;

			// define/setup map
			this.map = new Level1();
			map.reset();

			// set up coins
			this.coin5 = new Coin(310, 490);
			coin5.setBounds(new Rectangle(1, 1, 16, 16));
			coin5.setMap(map);

			this.coin6 = new Coin(720, 490);
			coin6.setBounds(new Rectangle(1, 1, 16, 16));
			coin6.setMap(map);

			this.coin7 = new Coin(1200, 490);
			coin7.setBounds(new Rectangle(1, 1, 16, 16));
			coin7.setMap(map);

			this.coin8 = new Coin(1650, 500);
			coin8.setBounds(new Rectangle(1, 1, 16, 16));
			coin8.setMap(map);

			this.coin9 = new Coin(1900, 400);
			coin9.setBounds(new Rectangle(1, 1, 16, 16));
			coin9.setMap(map);

			this.coin10 = new Coin(3100, 500);
			coin10.setBounds(new Rectangle(1, 1, 16, 16));
			coin10.setMap(map);

			// setup key
			this.key = new LevelKey(955, 450, "pixelKey.png");
			key.setMap(map);

			this.keyStatus = new SpriteFont(" ", 75, 100, "Comic Sans", 23, new Color(250, 204, 77));
			this.keyStatus.setOutlineColor(Color.black);
			this.keyStatus.setOutlineThickness(3);
			// setup player
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

			// end level
			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 2) {
			timeElapsed = 0;

			// setup map
			this.map = new Level2();
			map.reset();

			// setup coins
			this.coin10 = new Coin(310, 490);
			coin10.setBounds(new Rectangle(1, 1, 16, 16));
			coin10.setMap(map);

			this.coin11 = new Coin(720, 490);
			coin11.setBounds(new Rectangle(1, 1, 16, 16));
			coin11.setMap(map);

			this.coin12 = new Coin(1200, 490);
			coin12.setBounds(new Rectangle(1, 1, 16, 16));
			coin12.setMap(map);

			this.coin13 = new Coin(1650, 500);
			coin13.setBounds(new Rectangle(1, 1, 16, 16));
			coin13.setMap(map);

			this.coin14 = new Coin(1900, 400);
			coin14.setBounds(new Rectangle(1, 1, 16, 16));
			coin14.setMap(map);

			this.coin15 = new Coin(3100, 700);
			coin15.setBounds(new Rectangle(1, 1, 16, 16));
			coin15.setMap(map);

			// setup player
			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup key
			this.key = new LevelKey(955, 450, "pixelKey.png");
			key.setMap(map);

			// setup AudioPlayer
			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			// end level
			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} else if (currLevel == 3) {
			timeElapsed = 0;

			// setup map
			this.map = new Level3();
			map.reset();

			// setup coins
			this.coin15 = new Coin(310, 490);
			coin15.setBounds(new Rectangle(1, 1, 16, 16));
			coin15.setMap(map);

			this.coin16 = new Coin(720, 490);
			coin16.setBounds(new Rectangle(1, 1, 16, 16));
			coin16.setMap(map);

			this.coin17 = new Coin(1200, 490);
			coin17.setBounds(new Rectangle(1, 1, 16, 16));
			coin17.setMap(map);

			this.coin18 = new Coin(1650, 500);
			coin18.setBounds(new Rectangle(1, 1, 16, 16));
			coin18.setMap(map);

			this.coin19 = new Coin(1900, 400);
			coin19.setBounds(new Rectangle(1, 1, 16, 16));
			coin19.setMap(map);

			this.coin20 = new Coin(3100, 400);
			coin20.setBounds(new Rectangle(1, 1, 16, 16));
			coin20.setMap(map);

			// setup player
			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup key
			this.key = new LevelKey(450, 450, "pixelKey.png");
			key.setMap(map);

			// setup AudioPlayer
			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			// end level
			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} else if (currLevel == 4) {
			timeElapsed = 0;

			// setup map
			this.map = new Level4();
			map.reset();

			//setup coins
			this.coin20 = new Coin(100, 490);
			coin20.setBounds(new Rectangle(1, 1, 16, 16));
			coin20.setMap(map);

			this.coin21 = new Coin(140, 485);
			coin21.setBounds(new Rectangle(1, 1, 16, 16));
			coin21.setMap(map);

			this.coin22 = new Coin(340, 490);
			coin22.setBounds(new Rectangle(1, 1, 16, 16));
			coin22.setMap(map);

			this.coin23 = new Coin(540, 495);
			coin23.setBounds(new Rectangle(1, 1, 16, 16));
			coin23.setMap(map);

			this.coin24 = new Coin(640, 400);
			coin24.setBounds(new Rectangle(1, 1, 16, 16));
			coin24.setMap(map);

			this.coin25 = new Coin(545, 500);
			coin25.setBounds(new Rectangle(1, 1, 16, 16));
			coin25.setMap(map);

			// setup player
			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup key
			this.key = new LevelKey(955, 450, "pixelKey.png");
			key.setMap(map);

			// setup AudioPlayer
			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 5) {
			timeElapsed = 0;

			this.map = new Level5();
			map.reset();

			//setup coins
			this.coin25 = new Coin(340, 490);
			coin25.setBounds(new Rectangle(1, 1, 16, 16));
			coin25.setMap(map);

			this.coin26 = new Coin(250, 490);
			coin26.setBounds(new Rectangle(1, 1, 16, 16));
			coin26.setMap(map);

			this.coin27 = new Coin(290, 390);
			coin27.setBounds(new Rectangle(1, 1, 16, 16));
			coin27.setMap(map);

			this.coin28 = new Coin(300, 290);
			coin28.setBounds(new Rectangle(1, 1, 16, 16));
			coin28.setMap(map);

			this.coin29 = new Coin(260, 150);
			coin29.setBounds(new Rectangle(1, 1, 16, 16));
			coin29.setMap(map);

			this.coin30 = new Coin(300, 90);
			coin30.setBounds(new Rectangle(1, 1, 16, 16));
			coin30.setMap(map);

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup key
			this.key = new LevelKey(200, 450, "pixelKey.png");
			key.setMap(map);

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 6) {
			timeElapsed = 0;

			this.map = new Level6();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			//setup coins
			this.coin31 = new Coin(340, 490);
			coin31.setBounds(new Rectangle(1, 1, 16, 16));
			coin31.setMap(map);

			this.coin32 = new Coin(450, 490);
			coin32.setBounds(new Rectangle(1, 1, 16, 16));
			coin32.setMap(map);

			this.coin33 = new Coin(560, 390);
			coin33.setBounds(new Rectangle(1, 1, 16, 16));
			coin33.setMap(map);

			this.coin34 = new Coin(455, 290);
			coin34.setBounds(new Rectangle(1, 1, 16, 16));
			coin34.setMap(map);

			this.coin35 = new Coin(560, 150);
			coin35.setBounds(new Rectangle(1, 1, 16, 16));
			coin35.setMap(map);

			this.coin30 = new Coin(258, 90);
			coin30.setBounds(new Rectangle(1, 1, 16, 16));
			coin30.setMap(map);

			// setup key
			this.key = new LevelKey(650, 450, "pixelKey.png");
			key.setMap(map);

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 7) {
			timeElapsed = 0;

			this.map = new Level7();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			//setup coins
			this.coin35 = new Coin(340, 490);
			coin35.setBounds(new Rectangle(1, 1, 16, 16));
			coin35.setMap(map);

			this.coin36 = new Coin(550, 490);
			coin36.setBounds(new Rectangle(1, 1, 16, 16));
			coin36.setMap(map);

			this.coin37 = new Coin(590, 500);
			coin37.setBounds(new Rectangle(1, 1, 16, 16));
			coin37.setMap(map);

			this.coin38 = new Coin(655, 510);
			coin38.setBounds(new Rectangle(1, 1, 16, 16));
			coin38.setMap(map);

			this.coin39 = new Coin(670, 485);
			coin39.setBounds(new Rectangle(1, 1, 16, 16));
			coin39.setMap(map);

			this.coin40 = new Coin(858, 490);
			coin40.setBounds(new Rectangle(1, 1, 16, 16));
			coin40.setMap(map);

			// setup key
			this.key = new LevelKey(700, 450, "pixelKey.png");
			key.setMap(map);



			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 8) {
			timeElapsed = 0;

			this.map = new Level8();
			map.reset();

			//setup coins
			this.coin40 = new Coin(340, 490);
			coin40.setBounds(new Rectangle(1, 1, 16, 16));
			coin40.setMap(map);

			this.coin41 = new Coin(550, 500);
			coin41.setBounds(new Rectangle(1, 1, 16, 16));
			coin41.setMap(map);

			this.coin42 = new Coin(590, 510);
			coin42.setBounds(new Rectangle(1, 1, 16, 16));
			coin42.setMap(map);

			this.coin43 = new Coin(655, 490);
			coin43.setBounds(new Rectangle(1, 1, 16, 16));
			coin43.setMap(map);

			this.coin44 = new Coin(860, 495);
			coin44.setBounds(new Rectangle(1, 1, 16, 16));
			coin44.setMap(map);

			this.coin45 = new Coin(958, 590);
			coin45.setBounds(new Rectangle(1, 1, 16, 16));
			coin45.setMap(map);

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup key
			this.key = new LevelKey(700, 450, "pixelKey.png");
			key.setMap(map);

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 9) {
			timeElapsed = 0;

			this.map = new Level9();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup key
			this.key = new LevelKey(700, 450, "pixelKey.png");
			key.setMap(map);

			//setup coins
			this.coin45 = new Coin(340, 490);
			coin45.setBounds(new Rectangle(1, 1, 16, 16));
			coin45.setMap(map);

			this.coin46 = new Coin(450, 500);
			coin46.setBounds(new Rectangle(1, 1, 16, 16));
			coin46.setMap(map);

			this.coin47 = new Coin(660, 510);
			coin47.setBounds(new Rectangle(1, 1, 16, 16));
			coin47.setMap(map);

			this.coin48 = new Coin(755, 490);
			coin48.setBounds(new Rectangle(1, 1, 16, 16));
			coin48.setMap(map);

			this.coin49 = new Coin(960, 485);
			coin49.setBounds(new Rectangle(1, 1, 16, 16));
			coin49.setMap(map);

			this.coin50 = new Coin(1000, 590);
			coin50.setBounds(new Rectangle(1, 1, 16, 16));
			coin50.setMap(map);

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 10) {
			timeElapsed = 0;

			this.map = new Level10();
			map.reset();

			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// setup key
			this.key = new LevelKey(700, 450, "pixelKey.png");
			key.setMap(map);

			//setup coins
			this.coin50 = new Coin(240, 490);
			coin50.setBounds(new Rectangle(1, 1, 16, 16));
			coin50.setMap(map);

			this.coin51 = new Coin(550, 510);
			coin51.setBounds(new Rectangle(1, 1, 16, 16));
			coin51.setMap(map);

			this.coin52 = new Coin(660, 500);
			coin52.setBounds(new Rectangle(1, 1, 16, 16));
			coin52.setMap(map);

			this.coin53 = new Coin(755, 490);
			coin53.setBounds(new Rectangle(1, 1, 16, 16));
			coin53.setMap(map);

			this.coin54 = new Coin(760, 550);
			coin54.setBounds(new Rectangle(1, 1, 16, 16));
			coin54.setMap(map);

			this.coin55 = new Coin(958, 590);
			coin55.setBounds(new Rectangle(1, 1, 16, 16));
			coin55.setMap(map);

			try {
				levelMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Level1_Music.wav");
				levelMusic.play();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

			// end level
			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);
		} else if (currLevel == 11) {

			gameWonScreen = new GameWonScreen(this);
			this.map = new GameCompleteMap();
			map.reset();
			this.playLevelScreenState = PlayLevelScreenState.GAME_WON;

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

				if (currLevel == 0) {
					coin1.check(player);
					coin2.check(player);
					coin3.check(player);
					coin4.check(player);
					coin5.check(player);
				} else if (currLevel == 1) {
					coin5.check(player);
					coin6.check(player);
					coin7.check(player);
					coin8.check(player);
					coin9.check(player);
					coin10.check(player);
				} else if (currLevel == 2) {
					coin11.check(player);
					coin12.check(player);
					coin13.check(player);
					coin14.check(player);
					coin15.check(player);
				} else if (currLevel == 3) {
					coin16.check(player);
					coin17.check(player);
					coin18.check(player);
					coin19.check(player);
					coin20.check(player);
				}else if (currLevel == 4) {
					coin21.check(player);
					coin22.check(player);
					coin23.check(player);
					coin24.check(player);
					coin25.check(player);
				}else if (currLevel == 5) {
					coin26.check(player);
					coin27.check(player);
					coin28.check(player);
					coin29.check(player);
					coin30.check(player);
				}else if (currLevel == 6) {
					coin31.check(player);
					coin32.check(player);
					coin33.check(player);
					coin34.check(player);
					coin35.check(player);
				}else if (currLevel == 7) {
					coin36.check(player);
					coin37.check(player);
					coin38.check(player);
					coin39.check(player);
					coin40.check(player);
				}else if (currLevel == 8) {
					coin41.check(player);
					coin42.check(player);
					coin43.check(player);
					coin44.check(player);
					coin45.check(player);
				}else if (currLevel == 9) {
					coin46.check(player);
					coin47.check(player);
					coin48.check(player);
					coin49.check(player);
					coin50.check(player);
				}else if (currLevel == 10) {
					coin51.check(player);
					coin52.check(player);
					coin53.check(player);
					coin54.check(player);
					coin55.check(player);
				}


				key.check(player);

				coinCounter.setText("Coins: " + this.getCoinCount());

				gameTimer.setText("Time: " + (int) timeElapsed);

				keyStatusBar.setText("Key: ");

				if (player.getHealth() <= 30) {
					blinkTimer.start();
					healthBar.setColor(Color.RED);
				} else {
					healthBar.setColor(new Color(49, 207, 240));
					blinkTimer.healthReset();

				}

				healthBar.setText("Health: " + (int) player.getHealth());

				if (key.gotKey == false) {
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
			// wait on level lose screen to make a decision (either resets level or sends
			// player back to main menu)
			case LEVEL_LOSE: {

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


				if (currLevel != 11) 
				{
					if (!blink)
						healthBar.draw(graphicsHandler);
					
					gameTimer.draw(graphicsHandler);
					coinCounter.draw(graphicsHandler);
					keyStatusBar.draw(graphicsHandler);
					keyStatus.draw(graphicsHandler);
				}
				
				gameTimer.draw(graphicsHandler);
				coinCounter.draw(graphicsHandler);
				keyStatusBar.draw(graphicsHandler);
				keyStatus.draw(graphicsHandler);


				if (currLevel == 0) {
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
				}
				if (currLevel == 1) {
					if (coin6.gotCoin == false) {
						coin6.draw(graphicsHandler);
					}
					if (coin7.gotCoin == false) {
						coin7.draw(graphicsHandler);
					}
					if (coin8.gotCoin == false) {
						coin8.draw(graphicsHandler);
					}
					if (coin9.gotCoin == false) {
						coin9.draw(graphicsHandler);
					}
					if (coin10.gotCoin == false) {
						coin10.draw(graphicsHandler);
					}
				}

				if (currLevel == 2) {
					if (coin11.gotCoin == false) {
						coin11.draw(graphicsHandler);
					}
					if (coin12.gotCoin == false) {
						coin12.draw(graphicsHandler);
					}
					if (coin13.gotCoin == false) {
						coin13.draw(graphicsHandler);
					}
					if (coin14.gotCoin == false) {
						coin14.draw(graphicsHandler);
					}
					if (coin15.gotCoin == false) {
						coin15.draw(graphicsHandler);
					}
				}

				if (currLevel == 3) {
					if (coin16.gotCoin == false) {
						coin16.draw(graphicsHandler);
					}
					if (coin17.gotCoin == false) {
						coin17.draw(graphicsHandler);
					}
					if (coin18.gotCoin == false) {
						coin18.draw(graphicsHandler);
					}
					if (coin19.gotCoin == false) {
						coin19.draw(graphicsHandler);
					}
					if (coin20.gotCoin == false) {
						coin20.draw(graphicsHandler);
					}
				}

				if (currLevel == 4) {
					if (coin21.gotCoin == false) {
						coin21.draw(graphicsHandler);
					}
					if (coin22.gotCoin == false) {
						coin22.draw(graphicsHandler);
					}
					if (coin23.gotCoin == false) {
						coin23.draw(graphicsHandler);
					}
					if (coin24.gotCoin == false) {
						coin24.draw(graphicsHandler);
					}
					if (coin25.gotCoin == false) {
						coin25.draw(graphicsHandler);
					}
				}

				if (currLevel == 5) {
					if (coin26.gotCoin == false) {
						coin26.draw(graphicsHandler);
					}
					if (coin27.gotCoin == false) {
						coin27.draw(graphicsHandler);
					}
					if (coin28.gotCoin == false) {
						coin28.draw(graphicsHandler);
					}
					if (coin29.gotCoin == false) {
						coin29.draw(graphicsHandler);
					}
					if (coin30.gotCoin == false) {
						coin30.draw(graphicsHandler);
					}
				}
				if (currLevel == 6) {
					if (coin31.gotCoin == false) {
						coin31.draw(graphicsHandler);
					}
					if (coin32.gotCoin == false) {
						coin32.draw(graphicsHandler);
					}
					if (coin33.gotCoin == false) {
						coin33.draw(graphicsHandler);
					}
					if (coin34.gotCoin == false) {
						coin34.draw(graphicsHandler);
					}
					if (coin35.gotCoin == false) {
						coin35.draw(graphicsHandler);
					}
				}
				if (currLevel == 7) {
					if (coin36.gotCoin == false) {
						coin36.draw(graphicsHandler);
					}
					if (coin37.gotCoin == false) {
						coin37.draw(graphicsHandler);
					}
					if (coin38.gotCoin == false) {
						coin38.draw(graphicsHandler);
					}
					if (coin39.gotCoin == false) {
						coin39.draw(graphicsHandler);
					}
					if (coin40.gotCoin == false) {
						coin40.draw(graphicsHandler);
					}
				}
				if (currLevel == 8) {
					if (coin41.gotCoin == false) {
						coin41.draw(graphicsHandler);
					}
					if (coin42.gotCoin == false) {
						coin42.draw(graphicsHandler);
					}
					if (coin43.gotCoin == false) {
						coin43.draw(graphicsHandler);
					}
					if (coin44.gotCoin == false) {
						coin44.draw(graphicsHandler);
					}
					if (coin45.gotCoin == false) {
						coin45.draw(graphicsHandler);
					}
				}
				if (currLevel == 9) {
					if (coin46.gotCoin == false) {
						coin46.draw(graphicsHandler);
					}
					if (coin47.gotCoin == false) {
						coin47.draw(graphicsHandler);
					}
					if (coin48.gotCoin == false) {
						coin48.draw(graphicsHandler);
					}
					if (coin49.gotCoin == false) {
						coin49.draw(graphicsHandler);
					}
					if (coin50.gotCoin == false) {
						coin50.draw(graphicsHandler);
					}
				}
				if (currLevel == 10) {
					if (coin51.gotCoin == false) {
						coin51.draw(graphicsHandler);
					}
					if (coin52.gotCoin == false) {
						coin52.draw(graphicsHandler);
					}
					if (coin53.gotCoin == false) {
						coin53.draw(graphicsHandler);
					}
					if (coin54.gotCoin == false) {
						coin54.draw(graphicsHandler);
					}
					if (coin55.gotCoin == false) {
						coin55.draw(graphicsHandler);
					}
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
			case GAME_WON:
				gameWonScreen.draw(graphicsHandler);
				break;
		}
	}

	public void goBackToMenu() {
		screenCoordinator.setGameState(GameState.MENU);
		blinkTimer.healthReset();

	}

	public PlayLevelScreenState getPlayLevelScreenState() {
		return playLevelScreenState;
	}

	@Override
	public void onLevelCompleted() {
		if (playLevelScreenState != PlayLevelScreenState.LEVEL_COMPLETED) {
			playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
			levelCompletedStateChangeStart = true;
			key.gotKey = false;

			try {
				levelMusic.stop();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void onDeath() {
		if (playLevelScreenState != PlayLevelScreenState.LEVEL_LOSE) {
			playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;

			try {
				levelMusic.stop();
			} catch (Exception e) {
			}
		}
	}

	public boolean playerLose() {
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
		RUNNING, LEVEL_COMPLETED, LEVEL_LOSE, GAME_WON;
	}

	public int getCoinCount() {
		if (currLevel == 0) {
			coinCount = coin1.getCoinCount() + coin2.getCoinCount() + coin3.getCoinCount() + coin4.getCoinCount()
					+ coin5.getCoinCount();
			coinCount0 = coinCount;
		} else if (currLevel == 1) {
			coinCount = coinCount0 + coin6.getCoinCount() + coin7.getCoinCount() + coin8.getCoinCount() + coin9.getCoinCount() + coin10.getCoinCount();
			coinCount1 = coinCount;
		} else if (currLevel == 2) {
			coinCount = coinCount1 + coin11.getCoinCount() + coin12.getCoinCount() + coin13.getCoinCount() + coin14.getCoinCount() + coin15.getCoinCount();
			coinCount2 = coinCount;
		} else if (currLevel == 3) {
			coinCount = coinCount2 + coin16.getCoinCount() + coin17.getCoinCount() + coin18.getCoinCount() + coin19.getCoinCount() + coin20.getCoinCount();
			coinCount3 = coinCount;
		} else if (currLevel == 4) {
			coinCount = coinCount3 + coin21.getCoinCount() + coin22.getCoinCount() + coin23.getCoinCount() + coin24.getCoinCount() + coin25.getCoinCount();
			coinCount4 = coinCount;
		} else if (currLevel == 5) {
			coinCount = coinCount4 + coin26.getCoinCount() + coin27.getCoinCount() + coin28.getCoinCount() + coin29.getCoinCount() + coin30.getCoinCount();
			coinCount5 = coinCount;
		} else if (currLevel == 6) {
			coinCount = coinCount5 + coin31.getCoinCount() + coin32.getCoinCount() + coin33.getCoinCount() + coin34.getCoinCount() + coin35.getCoinCount();
			coinCount6 = coinCount;
		} else if (currLevel == 7) {
			coinCount = coinCount6 + coin36.getCoinCount() + coin37.getCoinCount() + coin38.getCoinCount() + coin39.getCoinCount() + coin40.getCoinCount();
			coinCount7 = coinCount;
		} else if (currLevel == 8) {
			coinCount = coinCount7 + coin41.getCoinCount() + coin42.getCoinCount() + coin43.getCoinCount() + coin44.getCoinCount() + coin45.getCoinCount();
			coinCount8 = coinCount;
		} else if (currLevel == 9) {
			coinCount = coinCount8 + coin46.getCoinCount() + coin47.getCoinCount() + coin48.getCoinCount() + coin49.getCoinCount() + coin50.getCoinCount();
			coinCount9 = coinCount;
		} else if (currLevel == 10) {
			coinCount = coinCount9 + coin51.getCoinCount() + coin52.getCoinCount() + coin53.getCoinCount() + coin54.getCoinCount() + coin55.getCoinCount();
		}
			return coinCount;
	}
}

