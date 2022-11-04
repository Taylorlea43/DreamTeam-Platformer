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
import Utils.BlinkTimer;
import Utils.ClockTimer;
import Utils.Point;
import Utils.Stopwatch;
import Sounds.AudioPlayer;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {

	public ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Coin coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10;
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
	protected int coinCount0, coinCount1, coinCount;
	protected AudioPlayer levelMusic;
	public boolean blink = false;
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
			this.coin5 = new Coin(110, 490);
			coin5.setBounds(new Rectangle(1, 1, 16, 16));
			coin5.setMap(map);

			this.coin6 = new Coin(520, 490);
			coin6.setBounds(new Rectangle(1, 1, 16, 16));
			coin6.setMap(map);

			this.coin7 = new Coin(800, 490);
			coin7.setBounds(new Rectangle(1, 1, 16, 16));
			coin7.setMap(map);

			this.coin8 = new Coin(950, 300);
			coin8.setBounds(new Rectangle(1, 1, 16, 16));
			coin8.setMap(map);

			this.coin9 = new Coin(1200, 400);
			coin9.setBounds(new Rectangle(1, 1, 16, 16));
			coin9.setMap(map);

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

			// setup player
			this.player = new Girl(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
			this.player.setMap(map);
			this.player.addListener(this);
			Point playerStartPosition = map.getPlayerStartPosition();
			this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
			this.playLevelScreenState = PlayLevelScreenState.RUNNING;

			// set up coins in the level
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
		} else if (currLevel == 4) {
			timeElapsed = 0;

			// setup map
			this.map = new Level4();
			map.reset();

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

			levelClearedScreen = new LevelClearedScreen(this);
			levelLoseScreen = new LevelLoseScreen(this);

		} else if (currLevel == 5) {
			timeElapsed = 0;

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
				//System.out.println(blink);
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

				if (!blink)
					healthBar.draw(graphicsHandler);

				player.draw(graphicsHandler);


				if (currLevel != 11) {
					gameTimer.draw(graphicsHandler);
					coinCounter.draw(graphicsHandler);
					healthBar.draw(graphicsHandler);
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
			coinCount = coinCount0+  coin6.getCoinCount() + coin7.getCoinCount() + coin8.getCoinCount() + coin9.getCoinCount();
		}

		return coinCount;
	}
}
