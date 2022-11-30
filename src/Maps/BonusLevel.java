package Maps;

import Enemies.*;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.LevelKey;
import GameObject.Rectangle;
import GameObject.Sprite;
import Level.*;
import NPCs.Walrus;
import SpriteFont.SpriteFont;
import Tilesets.BonusTileset;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Utils.Direction;
import Utils.Point;

import java.awt.*;
import java.util.ArrayList;


// Represents a test map to be used in a level
public class BonusLevel extends Map {

    private Sprite elephantUncaged, girrafeUncaged, bunnyUncaged, lionUncaged, sharkUncaged, mountainGoatUncaged, monkeyUncaged, penguinUncaged, parrotUncaged, lizardUncaged;

    public BonusLevel()
    {
        super("bonus_level.txt", new BonusTileset());
        //add elephant
        Point elephantLocation = getMapTile(14, 3).getLocation().subtractX(24).addY(6);
        elephantUncaged = new Sprite(ImageLoader.load("DiscoElephant.png"));
        elephantUncaged.setScale(15);
        elephantUncaged.setLocation(elephantLocation.x, elephantLocation.y);


        //add giraffe
        Point giraffeLocation = getMapTile(8, 3).getLocation();
        girrafeUncaged = new Sprite(ImageLoader.load("DiscoGirrafe.png"));
        girrafeUncaged.setScale(7);
        girrafeUncaged.setLocation(giraffeLocation.x, giraffeLocation.y);


        //add bunny
        Point bunnyLocation = getMapTile(7, 9).getLocation().subtractY(13);
        bunnyUncaged = new Sprite(ImageLoader.load("DiscoBunny.png"));
        bunnyUncaged.setScale(2);
        bunnyUncaged.setLocation(bunnyLocation.x, bunnyLocation.y);

        //add lion
        Point lionLocation = getMapTile(19, 6).getLocation();
        lionUncaged = new Sprite(ImageLoader.load("DiscoLion.png"));
        lionUncaged.setScale(9);
        lionUncaged.setLocation(lionLocation.x, lionLocation.y);

        //add shark
        Point sharkLocation = getMapTile(0, 9).getLocation().subtractX(10);
        sharkUncaged = new Sprite(ImageLoader.load("DiscoShark.png"));
        sharkUncaged.setScale(9);
        sharkUncaged.setLocation(sharkLocation.x, sharkLocation.y);

        //add mountain goat
        Point mountainGoatLocation = getMapTile(14, 8).getLocation().subtractY(10);
        mountainGoatUncaged = new Sprite(ImageLoader.load("DiscoGoat.png"));
        mountainGoatUncaged.setScale(5);
        mountainGoatUncaged.setLocation(mountainGoatLocation.x, mountainGoatLocation.y);

        //add monkey
        Point monkeyLocation = getMapTile(4, 8).getLocation();
        monkeyUncaged = new Sprite(ImageLoader.load("DiscoMonkey.png"));
        monkeyUncaged.setScale(4);
        monkeyUncaged.setLocation(monkeyLocation.x, monkeyLocation.y);

        //add penguin
        Point penguinLocation = getMapTile(17, 9).getLocation().subtractY(20);
        penguinUncaged = new Sprite(ImageLoader.load("DiscoPenguin.png"));
        penguinUncaged.setScale(3);
        penguinUncaged.setLocation(penguinLocation.x, penguinLocation.y);

        //add parrot
        Point parrotLocation = getMapTile(14, 5).getLocation().subtractX(20).subtractY(20);
        parrotUncaged = new Sprite(ImageLoader.load("DiscoParrot.png"));
        parrotUncaged.setScale(3);
        parrotUncaged.setLocation(parrotLocation.x, parrotLocation.y);

        //add lizard
        Point lizardLocation = getMapTile(10, 9).getLocation().subtractY(8);
        lizardUncaged = new Sprite(ImageLoader.load("DiscoLizard.png"));
        lizardUncaged.setScale(3);
        lizardUncaged.setLocation(lizardLocation.x, lizardLocation.y);
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        return enhancedMapTiles;
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        elephantUncaged.draw(graphicsHandler);
        bunnyUncaged.draw(graphicsHandler);
        lionUncaged.draw(graphicsHandler);
        sharkUncaged.draw(graphicsHandler);
        mountainGoatUncaged.draw(graphicsHandler);
        monkeyUncaged.draw(graphicsHandler);
        penguinUncaged.draw(graphicsHandler);
        parrotUncaged.draw(graphicsHandler);
        lionUncaged.draw(graphicsHandler);
    }



}
