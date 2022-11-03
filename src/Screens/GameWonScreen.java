package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.ScreenCoordinator;
import Screens.PlayLevelScreen;
import Level.Map;
import Maps.GameCompleteMap;
import Maps.TitleScreenMap;

public class GameWonScreen extends Screen {

    private PlayLevelScreen playLevelScreen;
    protected Map background;

    public GameWonScreen(PlayLevelScreen playLevelScreen){

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
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
    }
}
