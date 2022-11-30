package Screens;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import GameObject.Sprite;
import Level.Map;
import Maps.GameCompleteMap;
import Maps.Level10Complete;
import Maps.Level1Complete;
import Maps.Level2Complete;
import Maps.Level3Complete;
import Maps.Level4Complete;
import Maps.Level5Complete;
import Maps.Level6Complete;
import Maps.Level7Complete;
import Maps.Level8Complete;
import Maps.Level9Complete;
import Maps.TestMap;
import Maps.TutorialComplete;
import Sounds.AudioPlayer;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the level cleared screen
public class LevelClearedScreen extends Screen {
	protected SpriteFont winMessage, instructions;
	protected Map background;
	private Sprite elephantUncaged, girrafeUncaged, bunnyUncaged, lionUncaged, sharkUncaged, mountainGoatUncaged, monkeyUncaged, penguinUncaged, parrotUncaged, lizardUncaged, girl;
	protected KeyLocker keyLocker = new KeyLocker();
	protected PlayLevelScreen playLevelScreen;
	public int currLevel;

	public LevelClearedScreen(PlayLevelScreen playLevelScreen) 
	{
		this.playLevelScreen = playLevelScreen;

		initialize();
	}
	
	@Override
	public void initialize() 
	{
		winMessage = new SpriteFont("Level Cleared", Config.GAME_WINDOW_WIDTH/2-100, Config.GAME_WINDOW_HEIGHT/2-100, "Comic Sans", 30, Color.white);
		instructions = new SpriteFont("Press Space to go to the next Level or Escape to go back to the Main Menu", 320, 300, "Comic Sans", 20, Color.white);
		keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC); 
//		if (currLevel == 0)
//		{
//			background = new TutorialComplete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 1) {
//			background = new Level1Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 2) {
//			background = new Level2Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 3) {
//			background = new Level3Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 4) {
//			background = new Level4Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 5) {
//			background = new Level5Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 6) {
//			background = new Level6Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 7) {
//			background = new Level7Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 8) {
//			background = new Level8Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 9) {
//			background = new Level9Complete();
//			background.setAdjustCamera(false);
//		} else if (currLevel == 10) {
//			background = new Level10Complete();
//			background.setAdjustCamera(false);
//		}
	}

	@Override
	public void update() 
	{
		if (Keyboard.isKeyUp(Key.SPACE)) {
			keyLocker.unlockKey(Key.SPACE);
		}
		if (Keyboard.isKeyUp(Key.ESC)) {
			keyLocker.unlockKey(Key.ESC);
		}

		// if space is pressed, reset level. if escape is pressed, go back to main menu
		if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
			playLevelScreen.resetLevel();

			try {
				AudioPlayer startEffect = new AudioPlayer(false, "Resources/GameStart_Sound.wav");
				startEffect.play();
			}

			catch (Exception e) {
				System.out.println("Error with sound");
			}
		} else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
			playLevelScreen.goBackToMenu();
			try {
				AudioPlayer startEffect = new AudioPlayer(false, "Resources/GameStart_Sound.wav");
				startEffect.play();
			}

			catch (Exception e) {
				System.out.println("Error with sound");
			}
		}
		currLevel++;
	}

	public void draw(GraphicsHandler graphicsHandler) {
		// paint entire screen black and dislpay level cleared text
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
				Color.black);
		winMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);

	}
}
