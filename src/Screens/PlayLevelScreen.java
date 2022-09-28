package Screens;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Frame;
import GameObject.GameObject;
import Level.Map;
import Level.Player;
import Level.PlayerListener;
import Maps.TestMap;
import Players.Cat;
import SpriteFont.SpriteFont;
import Utils.Point;
import Utils.Stopwatch;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected GameObject coin, coin2, coin3;
    protected GameObject key;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected Stopwatch screenTimer = new Stopwatch();
    protected LevelClearedScreen levelClearedScreen;
    protected LevelLoseScreen levelLoseScreen;
    protected boolean levelCompletedStateChangeStart;
    protected SpriteFont gameTimer;
    protected SpriteFont coinCounter;


    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // define/setup map
        this.map = new TestMap();
        map.reset();
        
        //set up coins in the game
       Frame frame = new Frame(ImageLoader.load("coins.png"));
       this.coin = new GameObject(250,400, frame);
       coin.setMap(map);
       this.coin2 = new GameObject(740, 105, frame);
       coin2.setMap(map);
       this.coin3 = new GameObject(1300,200, frame);
        coin3.setMap(map);
        
        //setup key
        Frame frame1 = new Frame(ImageLoader.load("key.png"));
        this.key = new GameObject(1025, 250, frame1);
        key.setMap(map);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        this.player.addListener(this);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        

        // setup HUD
        this.gameTimer = new SpriteFont("Time: 0", 700, 25, "Comic Sans", 23, new Color(49, 207, 240));
        this.gameTimer.setOutlineColor(Color.black);
        this.gameTimer.setOutlineThickness(3);
        
        this.coinCounter = new SpriteFont("Coins: 0", 694, 50, "Comic Sans", 23, new Color(49, 207, 240));
        this.coinCounter.setOutlineColor(Color.black);
        this.coinCounter.setOutlineThickness(3);

        levelClearedScreen = new LevelClearedScreen();
        levelLoseScreen = new LevelLoseScreen(this);
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                if (levelCompletedStateChangeStart) {
                    screenTimer.setWaitTime(2500);
                    levelCompletedStateChangeStart = false;
                } else {
                    levelClearedScreen.update();
                    if (screenTimer.isTimeUp()) {
                        goBackToMenu();
                    }
                }
                break;
            // wait on level lose screen to make a decision (either resets level or sends player back to main menu)
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
                
                coin.draw(graphicsHandler);
                coin2.draw(graphicsHandler);
                coin3.draw(graphicsHandler);
                
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

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, LEVEL_LOSE
    }
}
