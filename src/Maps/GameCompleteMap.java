package Maps;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import GameObject.LevelKey;
import GameObject.Sprite;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Player;
import Screens.PlayLevelScreen;
import SpriteFont.SpriteFont;
import Tilesets.CommonTileset;
import Utils.Colors;
import Utils.Point;

import java.awt.*;
import java.util.ArrayList;

public class GameCompleteMap extends Map {

    private SpriteFont gameComplete, freeAnimals, weAreFree;
    private Sprite elephantUncaged, girrafeUncaged, bunnyUncaged, lionUncaged, sharkUncaged, mountainGoatUncaged, monkeyUncaged, penguinUncaged, parrotUncaged, lizardUncaged, girl;
    private Sprite partyHat, partyHat2, partyHat3, partyHat4, partyHat5, partyHat6, partyHat7, partyHat8, partyHat9, partyHat10, partyHat11;
    private Sprite textBubble;
    private LevelKey gotAllCoins;
    private EndLevelBox discoBall;
    private Player player;

    public GameCompleteMap(){
        super("game_complete_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(2, 8).getLocation();


        //add game completed and free animals
        gameComplete = new SpriteFont("GAME COMPLETE", Config.GAME_WINDOW_WIDTH/2-150, 100, "Impact", 62, new Color(0, 0, 0));
        freeAnimals = new SpriteFont("YOU SAVED ALL THE ANIMALS!!!", Config.GAME_WINDOW_WIDTH/2-100, 120, "Impact", 24, new Color(0, 0, 0));


        /*Point girlLocation = getMapTile(6, 7).getLocation().subtractX(24).subtractY(6);
        girl = new Sprite(ImageLoader.loadSubImage("girlNoLines.png", Colors.MAGENTA, 0, 0, 55, 85));
        girl.setScale(2);
        girl.setLocation(girlLocation.x, girlLocation.y);
        partyHat11 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat11.setScale(3);
        Point partyHatLocation10 = getMapTile(6,6).getLocation().subtractX(5).addY(10);
        partyHat11.setLocation(partyHatLocation10.x, partyHatLocation10.y);*/


        //add elephant
        Point elephantLocation = getMapTile(14, 3).getLocation().subtractX(24).addY(6);
		elephantUncaged = new Sprite(ImageLoader.load("elephantUncaged.png"));
		elephantUncaged.setScale(15);
		elephantUncaged.setLocation(elephantLocation.x, elephantLocation.y);
        partyHat = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat.setScale(10);
        Point partyHatLocation = getMapTile(15,3).getLocation().subtractY(20);
        partyHat.setLocation(partyHatLocation.x, partyHatLocation.y);


        //add giraffe
        Point giraffeLocation = getMapTile(8, 3).getLocation();
		girrafeUncaged = new Sprite(ImageLoader.load("giraffeUncaged.png"));
		girrafeUncaged.setScale(7);
		girrafeUncaged.setLocation(giraffeLocation.x, giraffeLocation.y);
        partyHat2 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat2.setScale(3);
        Point partyHatLocation1 = getMapTile(9,3).getLocation().subtractY(13).addX(35);
        partyHat2.setLocation(partyHatLocation1.x, partyHatLocation1.y);
        Point BubbleLocation = getMapTile(10, 3).getLocation().addX(35).subtractY(30);
        textBubble = new Sprite(ImageLoader.load("textBubble.png"));
        textBubble.setScale(6);
        textBubble.setLocation(BubbleLocation.x, BubbleLocation.y);
        weAreFree = new SpriteFont("We are free!", 540, 165, "Impact", 18, new Color(0, 0, 0));


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
        Point lionLocation = getMapTile(19, 6).getLocation();
		lionUncaged = new Sprite(ImageLoader.load("LionUncaged.png"));
		lionUncaged.setScale(9);
		lionUncaged.setLocation(lionLocation.x, lionLocation.y);
        partyHat4 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat4.setScale(8);
        Point partyHatLocation3 = getMapTile(19,5).getLocation().subtractY(20).addX(15);
        partyHat4.setLocation(partyHatLocation3.x, partyHatLocation3.y);

        //add shark
    	Point sharkLocation = getMapTile(0, 9).getLocation().subtractX(10);
		sharkUncaged = new Sprite(ImageLoader.load("sharkUncaged.png"));
		sharkUncaged.setScale(9);
		sharkUncaged.setLocation(sharkLocation.x, sharkLocation.y);
        partyHat5 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat5.setScale(6);
        Point partyHatLocation4 = getMapTile(1,8).getLocation().subtractX(15).subtractY(10);
        partyHat5.setLocation(partyHatLocation4.x, partyHatLocation4.y);

        //add mountain goat
    	Point mountainGoatLocation = getMapTile(14, 8).getLocation().subtractY(10);
		mountainGoatUncaged = new Sprite(ImageLoader.load("mountainGoatUncaged.png"));
		mountainGoatUncaged.setScale(5);
		mountainGoatUncaged.setLocation(mountainGoatLocation.x, mountainGoatLocation.y);
        partyHat6 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat6.setScale(4);
        Point partyHatLocation5 = getMapTile(15,7).getLocation().subtractX(35).addY(15);
        partyHat6.setLocation(partyHatLocation5.x, partyHatLocation5.y);

        //add monkey
    	Point monkeyLocation = getMapTile(4, 8).getLocation();
		monkeyUncaged = new Sprite(ImageLoader.load("monkeyUncaged.png"));
		monkeyUncaged.setScale(4);
		monkeyUncaged.setLocation(monkeyLocation.x, monkeyLocation.y);
        partyHat7 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat7.setScale(3);
        Point partyHatLocation6 = getMapTile(5,8).getLocation().subtractX(30);
        partyHat7.setLocation(partyHatLocation6.x, partyHatLocation6.y);

        //add penguin
        Point penguinLocation = getMapTile(17, 9).getLocation().subtractY(20);
		penguinUncaged = new Sprite(ImageLoader.load("penguinUncaged.png"));
		penguinUncaged.setScale(3);
		penguinUncaged.setLocation(penguinLocation.x, penguinLocation.y);
        partyHat8 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat8.setScale(3);
        Point partyHatLocation7 = getMapTile(17,8).getLocation().addX(20);
        partyHat8.setLocation(partyHatLocation7.x, partyHatLocation7.y);

        //add parrot
        Point parrotLocation = getMapTile(14, 5).getLocation().subtractX(20).subtractY(20);
		parrotUncaged = new Sprite(ImageLoader.load("parrotUncaged.png"));
		parrotUncaged.setScale(3);
		parrotUncaged.setLocation(parrotLocation.x, parrotLocation.y);
        partyHat9 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat9.setScale(2);
        Point partyHatLocation8 = getMapTile(14,4).getLocation().addY(10);
        partyHat9.setLocation(partyHatLocation8.x, partyHatLocation8.y);

        //add lizard
        Point lizardLocation = getMapTile(10, 9).getLocation().subtractY(8);
		lizardUncaged = new Sprite(ImageLoader.load("lizardUncaged.png"));
		lizardUncaged.setScale(3);
		lizardUncaged.setLocation(lizardLocation.x, lizardLocation.y);
        partyHat10 = new Sprite(ImageLoader.load("PartyHat.png"));
        partyHat10.setScale(2);
        Point partyHatLocation9 = getMapTile(11,9).getLocation().subtractX(20);
        partyHat10.setLocation(partyHatLocation9.x, partyHatLocation9.y);

    }

    public void setGotAllCoins(boolean t){
        gotAllCoins.setGotKey(t);
    }


    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new EndLevelBox(getMapTile(12, 4).getLocation(), "DiscoBall.png",gotAllCoins, 24, 24));

        return enhancedMapTiles;
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
        partyHat6.draw(graphicsHandler);
        monkeyUncaged.draw(graphicsHandler);
        partyHat7.draw(graphicsHandler);
        penguinUncaged.draw(graphicsHandler);
        partyHat8.draw(graphicsHandler);
        parrotUncaged.draw(graphicsHandler);
        partyHat9.draw(graphicsHandler);
        //girl.draw(graphicsHandler);
        partyHat10.draw(graphicsHandler);
        lizardUncaged.draw(graphicsHandler);
       // partyHat11.draw(graphicsHandler);
        textBubble.draw(graphicsHandler);
        weAreFree.draw(graphicsHandler);
    }
}
