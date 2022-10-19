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
    private Sprite elephantUncaged, girrafeUncaged, bunnyUncaged, lionUncaged;

    public TitleScreenMap() {
        super("title_screen_map.txt", new CommonTileset());
        Point girlLocation = getMapTile(6, 7).getLocation().subtractX(24).subtractY(6);
        girl = new Sprite(ImageLoader.loadSubImage("girlNoLines.png", Colors.MAGENTA, 0, 0, 55, 85));
        girl.setScale(2);
        girl.setLocation(girlLocation.x, girlLocation.y);

        //add game title
        zooMania = new SpriteFont("ZOO MANIA", 250, 100, "Impact", 62, new Color(0, 0, 0));

        //add elephant
        Point elephantLocation = getMapTile(    8, 3).getLocation().subtractX(24).addY(6);
        elephantUncaged = new Sprite(ImageLoader.load("elephantUncaged.png"));
        elephantUncaged.setScale(15);
        elephantUncaged.setLocation(elephantLocation.x, elephantLocation.y);

        //add giraffe
        Point giraffeLocation = getMapTile(1, 3).getLocation();
        girrafeUncaged = new Sprite(ImageLoader.load("giraffeUncaged.png"));
        girrafeUncaged.setScale(7);
        girrafeUncaged.setLocation(giraffeLocation.x, giraffeLocation.y);

        //add bunny
        Point bunnyLocation = getMapTile(7, 9).getLocation().subtractY(13);
        bunnyUncaged = new Sprite(ImageLoader.load("BunnyUncaged.png"));
        bunnyUncaged.setScale(2);
        bunnyUncaged.setLocation(bunnyLocation.x, bunnyLocation.y);

        //add lion
        Point lionLocation = getMapTile(11, 6).getLocation();
        lionUncaged = new Sprite(ImageLoader.load("LionUncaged.png"));
        lionUncaged.setScale(9);
        lionUncaged.setLocation(lionLocation.x, lionLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        girl.draw(graphicsHandler);
        zooMania.draw(graphicsHandler);
        elephantUncaged.draw(graphicsHandler);
        girrafeUncaged.draw(graphicsHandler);
        bunnyUncaged.draw(graphicsHandler);
        lionUncaged.draw(graphicsHandler);
    } 

}
