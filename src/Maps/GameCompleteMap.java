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

public class GameCompleteMap extends Map {

    private SpriteFont gameComplete, freeAnimals;
    private Sprite elephantUncaged, girrafeUncaged, bunnyUncaged, lionUncaged, sharkUncaged, mountainGoatUncaged, monkeyUncaged, penguinUncaged, parrotUncaged, lizardUncaged, girl;
    private Sprite partyHat, partyHat2, partyHat3, partyHat4, partyHat5;

    public GameCompleteMap(){
        super("title_screen_map.txt", new CommonTileset());

        //add game completed and free animals
        gameComplete = new SpriteFont("GAME COMPLETE", 250, 100, "Impact", 62, new Color(0, 0, 0));
        freeAnimals = new SpriteFont("YOU SAVED ALL THE ANIMALS!!!", 285, 120, "Impact", 24, new Color(0, 0, 0));

        Point girlLocation = getMapTile(6, 7).getLocation().subtractX(24).subtractY(6);
        girl = new Sprite(ImageLoader.loadSubImage("girlNoLines.png", Colors.MAGENTA, 0, 0, 55, 85));
        girl.setScale(2);
        girl.setLocation(girlLocation.x, girlLocation.y);

        //add elephant
        Point elephantLocation = getMapTile(    8, 3).getLocation().subtractX(24).addY(6);
        elephantUncaged = new Sprite(ImageLoader.load("elephantUncaged.png"));
        elephantUncaged.setScale(15);
        elephantUncaged.setLocation(elephantLocation.x, elephantLocation.y);
        partyHat = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat.setScale(10);
        Point partyHatLocation = getMapTile(9,3).getLocation().subtractY(20);
        partyHat.setLocation(partyHatLocation.x, partyHatLocation.y);


        //add giraffe
        Point giraffeLocation = getMapTile(3, 3).getLocation();
        girrafeUncaged = new Sprite(ImageLoader.load("giraffeUncaged.png"));
        girrafeUncaged.setScale(7);
        girrafeUncaged.setLocation(giraffeLocation.x, giraffeLocation.y);
        partyHat2 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat2.setScale(3);
        Point partyHatLocation1 = getMapTile(4,3).getLocation().subtractY(13).addX(35);
        partyHat2.setLocation(partyHatLocation1.x, partyHatLocation1.y);

        //add bunny
        Point bunnyLocation = getMapTile(7, 9).getLocation().subtractY(13);
        bunnyUncaged = new Sprite(ImageLoader.load("BunnyUncaged.png"));
        bunnyUncaged.setScale(2);
        bunnyUncaged.setLocation(bunnyLocation.x, bunnyLocation.y);
        partyHat3 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat3.setScale(3);
        Point partyHatLocation2 = getMapTile(7,9).getLocation().subtractY(30).addX(5);
        partyHat3.setLocation(partyHatLocation2.x, partyHatLocation2.y);

        //add lion
        Point lionLocation = getMapTile(11, 6).getLocation();
        lionUncaged = new Sprite(ImageLoader.load("LionUncaged.png"));
        lionUncaged.setScale(9);
        lionUncaged.setLocation(lionLocation.x, lionLocation.y);
        partyHat4 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat4.setScale(8);
        Point partyHatLocation3 = getMapTile(12,5).getLocation().subtractY(20).addX(15);
        partyHat4.setLocation(partyHatLocation3.x, partyHatLocation3.y);

        //add shark
        Point sharkLocation = getMapTile(0, 9).getLocation().subtractX(10);
        sharkUncaged = new Sprite(ImageLoader.load("sharkUncaged.png"));
        sharkUncaged.setScale(10);
        sharkUncaged.setLocation(sharkLocation.x, sharkLocation.y);
        partyHat5 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat5.setScale(6);
        Point partyHatLocation4 = getMapTile(1,8).getLocation().subtractX(15).subtractY(10);
        partyHat5.setLocation(partyHatLocation4.x, partyHatLocation4.y);

        //add mountain goat
        Point mountainGoatLocation = getMapTile(11, 8).getLocation().subtractY(10);
        mountainGoatUncaged = new Sprite(ImageLoader.load("mountainGoatUncaged.png"));
        mountainGoatUncaged.setScale(5);
        mountainGoatUncaged.setLocation(mountainGoatLocation.x, mountainGoatLocation.y);

        //add monkey
        Point monkeyLocation = getMapTile(4, 8).getLocation();
        monkeyUncaged = new Sprite(ImageLoader.load("monkeyUncaged.png"));
        monkeyUncaged.setScale(4);
        monkeyUncaged.setLocation(monkeyLocation.x, monkeyLocation.y);

        //add penguin
        Point penguinLocation = getMapTile(8, 9).getLocation().subtractY(20);
        penguinUncaged = new Sprite(ImageLoader.load("penguinUncaged.png"));
        penguinUncaged.setScale(3);
        penguinUncaged.setLocation(penguinLocation.x, penguinLocation.y);

        //add parrot
        Point parrotLocation = getMapTile(8, 5).getLocation().subtractY(20).subtractX(5);
        parrotUncaged = new Sprite(ImageLoader.load("parrotUncaged.png"));
        parrotUncaged.setScale(3);
        parrotUncaged.setLocation(parrotLocation.x, parrotLocation.y);

        //add lizard
        Point lizardLocation = getMapTile(10, 9).getLocation().subtractY(8);
        lizardUncaged = new Sprite(ImageLoader.load("lizardUncaged.png"));
        lizardUncaged.setScale(3);
        lizardUncaged.setLocation(lizardLocation.x, lizardLocation.y);

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        gameComplete.draw(graphicsHandler);
        freeAnimals.draw(graphicsHandler);
        elephantUncaged.draw(graphicsHandler);
        partyHat.draw(graphicsHandler);
        girrafeUncaged.draw(graphicsHandler);
        partyHat2.draw(graphicsHandler);
        bunnyUncaged.draw(graphicsHandler);
        partyHat3.draw(graphicsHandler);
        lionUncaged.draw(graphicsHandler);
        partyHat4.draw(graphicsHandler);
        sharkUncaged.draw(graphicsHandler);
        partyHat5.draw(graphicsHandler);
        mountainGoatUncaged.draw(graphicsHandler);
        monkeyUncaged.draw(graphicsHandler);
        penguinUncaged.draw(graphicsHandler);
        parrotUncaged.draw(graphicsHandler);
        girl.draw(graphicsHandler);
        lizardUncaged.draw(graphicsHandler);
    }
}
