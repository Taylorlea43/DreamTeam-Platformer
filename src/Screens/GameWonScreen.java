package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.GameCompleteMap;
import Maps.TitleScreenMap;

public class GameWonScreen extends Screen {

    protected ScreenCoordinator screenCoordinator;
    protected Map background;

    public GameWonScreen(ScreenCoordinator screenCoordinator){
        this.screenCoordinator = screenCoordinator;
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
