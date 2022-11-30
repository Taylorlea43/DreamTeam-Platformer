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
import Maps.TutorialComplete;
import Sounds.AudioPlayer;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the level cleared screen
public class LevelClearedScreen extends Screen {
	protected Map map;
	protected SpriteFont winMessage, instructions;
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
        
//		if (currLevel == 0){
//			this.map = new TutorialComplete();
//			map.reset();
//		} else if (currLevel == 1) {
//			this.map = new Level1Complete();
//			map.reset();
//		} else if (currLevel == 2) {
//			this.map = new Level2Complete();
//			map.reset();
//		} else if (currLevel == 3) {
//			this.map = new Level3Complete();
//			map.reset();
//		} else if (currLevel == 4) {
//			this.map = new Level4Complete();
//			map.reset();
//		} else if (currLevel == 5) {
//			this.map = new Level5Complete();
//			map.reset();
//		} else if (currLevel == 6) {
//			this.map = new Level6Complete();
//			map.reset();
//		} else if (currLevel == 7) {
//			this.map = new Level7Complete();
//			map.reset();
//		} else if (currLevel == 8) {
//			this.map = new Level8Complete();
//			map.reset();
//		} else if (currLevel == 9) {
//			this.map = new Level9Complete();
//			map.reset();
//		} else if (currLevel == 10) {
//			this.map = new Level10Complete();
//			map.reset();
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
