package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import SpriteFont.SpriteFont;
import Tilesets.CommonTileset;
import Utils.Colors;
import Utils.Point;

import java.awt.*;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    private Sprite girl;
    private SpriteFont zooMania;
    private Sprite elephantUncaged, girrafeUncaged;

    public TitleScreenMap() {
        super("title_screen_map.txt", new CommonTileset());
        Point girlLocation = getMapTile(6, 7).getLocation().subtractX(24).subtractY(6);
        girl = new Sprite(ImageLoader.loadSubImage("girlNoLines.png", Colors.MAGENTA, 0, 0, 55, 85));
        girl.setScale(2);
        girl.setLocation(girlLocation.x, girlLocation.y);

        //add game title
        zooMania = new SpriteFont("ZOO MANIA", 250, 100, "Impact", 62, new Color(0, 0, 0));

        //add elephant
        Point elephantLocation = getMapTile(    9, 3).getLocation().subtractX(24).addY(6);
        elephantUncaged = new Sprite(ImageLoader.load("elephantUncaged.png"));
        elephantUncaged.setScale(15);
        elephantUncaged.setLocation(elephantLocation.x, elephantLocation.y);

        //add giraffe
        Point giraffeLocation = getMapTile(1, 4).getLocation().subtractY(35);
        girrafeUncaged = new Sprite(ImageLoader.load("giraffeUncaged.png"));
        girrafeUncaged.setScale(7);
        girrafeUncaged.setLocation(giraffeLocation.x, elephantLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        girl.draw(graphicsHandler);
        zooMania.draw(graphicsHandler);
        elephantUncaged.draw(graphicsHandler);
        girrafeUncaged.draw(graphicsHandler);
    } 

}
