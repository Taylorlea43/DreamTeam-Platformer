package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;
import Sounds.AudioPlayer;

import java.awt.*;
import java.io.File;
import java.lang.ProcessHandle.Info;

import javax.security.auth.login.FailedLoginException;
import javax.swing.plaf.ProgressBarUI;

// This is the class for the main menu screen
public class MenuScreen extends Screen {
	protected ScreenCoordinator screenCoordinator;
	protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
	protected int menuItemSelected = -1;
	protected SpriteFont playGame;
	protected SpriteFont credits;
	protected SpriteFont quit;
	protected SpriteFont avatar;
	protected SpriteFont instructions;
	protected Map background;
	protected Stopwatch keyTimer = new Stopwatch();
	protected int pointerLocationX, pointerLocationY;
	protected KeyLocker keyLocker = new KeyLocker();
	protected static AudioPlayer menuMusic;
	protected AudioPlayer startEffect;
	protected static boolean musicAlreadyPlaying = false;

	public MenuScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}

	@Override
	public void initialize() { 
		playGame = new SpriteFont("PLAY GAME", Config.GAME_WINDOW_WIDTH / 2 - 105, 150, "Comic Sans", 30,
				new Color(49, 207, 240));
		playGame.setOutlineColor(Color.black);
		playGame.setOutlineThickness(3);
		
		credits = new SpriteFont("CREDITS", Config.GAME_WINDOW_WIDTH / 2 - 105, 200, "Comic Sans", 30,
				new Color(49, 207, 240));
		credits.setOutlineColor(Color.black);
		credits.setOutlineThickness(3);
		
		quit = new SpriteFont("QUIT", Config.GAME_WINDOW_WIDTH / 2 - 105, 250, "Comic Sans", 30,
				new Color(49, 207, 240));
		quit.setOutlineColor(Color.black);
		quit.setOutlineThickness(3);
		
		avatar = new SpriteFont("CHOOSE AVATAR", Config.GAME_WINDOW_WIDTH / 2 - 105, 300, "Comic Sans", 30, new Color(49, 207, 240));
		avatar.setOutlineColor(Color.black);
		avatar.setOutlineThickness(3);
		
		instructions = new SpriteFont("INSTRUCTIONS", Config.GAME_WINDOW_WIDTH / 2 - 105, 350, "Comic Sans", 30, new Color(49, 207, 240));
		instructions.setOutlineColor(Color.black);
		instructions.setOutlineThickness(3);
		
		background = new TitleScreenMap();
		background.setAdjustCamera(false);
		keyTimer.setWaitTime(200);
		menuItemSelected = -1;
		keyLocker.lockKey(Key.SPACE);

		// setup AudioPlayer
		try {
			if (musicAlreadyPlaying == false) {
				menuMusic = new AudioPlayer(true, "Resources/Zoo-Mania_Sample_Music.wav");
				menuMusic.play();
			}
		}

		catch (Exception e) {
			System.out.println("Error with playing sound.");
			e.printStackTrace();
		}
	}

	public void update() {
		// update background map (to play tile animations)
		background.update(null);

		// if down or up is pressed, change menu item "hovered" over (blue square in
		// front of text will move along with currentMenuItemHovered changing)
		if (Keyboard.isKeyDown(Key.DOWN) && keyTimer.isTimeUp()) {
			keyTimer.reset();
			currentMenuItemHovered++;
		} else if (Keyboard.isKeyDown(Key.UP) && keyTimer.isTimeUp()) {
			keyTimer.reset();
			currentMenuItemHovered--;
		}

		// if down is pressed on last menu item or up is pressed on first menu item,
		// "loop" the selection back around to the beginning/end
		if (currentMenuItemHovered > 4) {
			currentMenuItemHovered = 0;
		} else if (currentMenuItemHovered < 0) {
			currentMenuItemHovered = 4;
		}

		// sets location for blue square in front of text (pointerLocation) and also
		// sets color of spritefont text based on which menu item is being hovered
		if (currentMenuItemHovered == 0) {
			playGame.setColor(new Color(255, 215, 0));
			credits.setColor(new Color(49, 207, 240));
			quit.setColor(new Color(49, 207, 240));
			avatar.setColor(new Color(49, 207, 240));
			instructions.setColor(new Color(49, 207, 240));

			pointerLocationX = 495;
			pointerLocationY = 125;
		} else if (currentMenuItemHovered == 1) {
			playGame.setColor(new Color(49, 207, 240));
			credits.setColor(new Color(255, 215, 0));
			quit.setColor(new Color(49, 207, 240));
			avatar.setColor(new Color(49, 207, 240));
			instructions.setColor(new Color(49, 207, 240));

			pointerLocationX = 495;
			pointerLocationY = 175;
		} else if (currentMenuItemHovered == 2) {
			playGame.setColor(new Color(49, 207, 240));
			credits.setColor(new Color(49, 207, 240));
			quit.setColor(new Color(255, 215, 0));
			avatar.setColor(new Color(49, 207, 240));
			instructions.setColor(new Color(49, 207, 240));
			
			pointerLocationX = 495;
			pointerLocationY = 225;
		} else if (currentMenuItemHovered == 3) {
			playGame.setColor(new Color(49, 207, 240));
			credits.setColor(new Color(49, 207, 240));
			quit.setColor(new Color(49, 207, 240));
			avatar.setColor(new Color(255, 215, 0));
			instructions.setColor(new Color(49, 207, 240));
			
			pointerLocationX = 495;
			pointerLocationY = 275;
		} else if (currentMenuItemHovered == 4) {
			playGame.setColor(new Color(49, 207, 240));
			credits.setColor(new Color(49, 207, 240));
			quit.setColor(new Color(49, 207, 240));
			avatar.setColor(new Color(49, 207, 240));
			instructions.setColor(new Color(255, 215, 0));
			
			pointerLocationX = 495;
			pointerLocationY = 325;
		}
		// if space is pressed on menu item, change to appropriate screen based on which
		// menu item was chosen
		if (Keyboard.isKeyUp(Key.SPACE)) {
			keyLocker.unlockKey(Key.SPACE);
		}
		if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
			try {
				startEffect = new AudioPlayer(false, "Resources/GameStart_Sound.wav");
				startEffect.play();
			}

			catch (Exception e) {
				System.out.println("Error with sound");
			}

			menuItemSelected = currentMenuItemHovered;
			if (menuItemSelected == 0) {
				try {
					musicAlreadyPlaying = false;
					menuMusic.stop();
				}

				catch (Exception e) {
					System.out.println("Error with music");
					e.printStackTrace();
				}
				screenCoordinator.setGameState(GameState.LEVEL);

			} else if (menuItemSelected == 1) {
				screenCoordinator.setGameState(GameState.CREDITS);
			} else if (menuItemSelected == 2) {
				System.exit(0);
			} else if (menuItemSelected == 3) {
				screenCoordinator.setGameState(GameState.AVATAR);
			} else if (menuItemSelected ==4) {
				screenCoordinator.setGameState(GameState.INSTUCTIONS);
			}
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		background.draw(graphicsHandler);
		playGame.draw(graphicsHandler);
		credits.draw(graphicsHandler);
		quit.draw(graphicsHandler);
		avatar.draw(graphicsHandler);
		instructions.draw(graphicsHandler);

		graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20,
				new Color(49, 207, 240), Color.black, 2);
	}

	public int getMenuItemSelected() {
		return menuItemSelected;
	}
}