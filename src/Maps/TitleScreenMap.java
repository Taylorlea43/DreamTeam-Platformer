package Maps;

import Enemies.ZookeeperEnemy;
import Engine.Config;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import SpriteFont.SpriteFont;
import Tilesets.CommonTileset;
import Utils.Colors;
import Utils.Direction;
import Utils.Point;

import java.awt.*;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

	private Sprite girl;
	private SpriteFont zooMania;
	private Sprite elephantUncaged, girrafeUncaged, bunnyUncaged, lionUncaged, sharkUncaged, mountainGoatUncaged,
			monkeyUncaged, penguinUncaged, parrotUncaged, lizardUncaged;
	private ZookeeperEnemy zookeeperTitle;

	public TitleScreenMap() {
		super("title_screen_map.txt", new CommonTileset());
		Point girlLocation = getMapTile(13, 7).getLocation().subtractX(24).subtractY(6);
		girl = new Sprite(ImageLoader.loadSubImage("girlNoLines.png", Colors.MAGENTA, 0, 0, 55, 85));
		girl.setScale(2);
		girl.setLocation(girlLocation.x, girlLocation.y);

		// add game title
		zooMania = new SpriteFont("ZOO MANIA", Config.GAME_WINDOW_WIDTH/2-150, 100, "Impact", 62, new Color(0, 0, 0));

		// add elephant
		Point elephantLocation = getMapTile(14, 3).getLocation().subtractX(24).addY(6);
		elephantUncaged = new Sprite(ImageLoader.load("elephantUncaged.png"));
		elephantUncaged.setScale(15);
		elephantUncaged.setLocation(elephantLocation.x, elephantLocation.y);

		// add giraffe
		Point giraffeLocation = getMapTile(8, 3).getLocation();
		girrafeUncaged = new Sprite(ImageLoader.load("giraffeUncaged.png"));
		girrafeUncaged.setScale(7);
		girrafeUncaged.setLocation(giraffeLocation.x, giraffeLocation.y);

		// add bunny
		Point bunnyLocation = getMapTile(7, 9).getLocation().subtractY(13);
		bunnyUncaged = new Sprite(ImageLoader.load("BunnyUncaged.png"));
		bunnyUncaged.setScale(2);
		bunnyUncaged.setLocation(bunnyLocation.x, bunnyLocation.y);

		// add lion
		Point lionLocation = getMapTile(19, 6).getLocation();
		lionUncaged = new Sprite(ImageLoader.load("LionUncaged.png"));
		lionUncaged.setScale(9);
		lionUncaged.setLocation(lionLocation.x, lionLocation.y);

		// add shark
		Point sharkLocation = getMapTile(0, 9).getLocation().subtractX(10);
		sharkUncaged = new Sprite(ImageLoader.load("sharkUncaged.png"));
		sharkUncaged.setScale(9);
		sharkUncaged.setLocation(sharkLocation.x, sharkLocation.y);

		// add mountain goat
		Point mountainGoatLocation = getMapTile(14, 8).getLocation().subtractY(10);
		mountainGoatUncaged = new Sprite(ImageLoader.load("mountainGoatUncaged.png"));
		mountainGoatUncaged.setScale(5);
		mountainGoatUncaged.setLocation(mountainGoatLocation.x, mountainGoatLocation.y);

		// add monkey
		Point monkeyLocation = getMapTile(4, 8).getLocation();
		monkeyUncaged = new Sprite(ImageLoader.load("monkeyUncaged.png"));
		monkeyUncaged.setScale(4);
		monkeyUncaged.setLocation(monkeyLocation.x, monkeyLocation.y);

		// add penguin
		Point penguinLocation = getMapTile(17, 9).getLocation().subtractY(20);
		penguinUncaged = new Sprite(ImageLoader.load("penguinUncaged.png"));
		penguinUncaged.setScale(3);
		penguinUncaged.setLocation(penguinLocation.x, penguinLocation.y);

		// add parrot
		Point parrotLocation = getMapTile(14, 2).getLocation().subtractY(20);
		parrotUncaged = new Sprite(ImageLoader.load("parrotUncaged.png"));
		parrotUncaged.setScale(3);
		parrotUncaged.setLocation(parrotLocation.x, parrotLocation.y);

		// add lizard
		Point lizardLocation = getMapTile(10, 9).getLocation().subtractY(8);
		lizardUncaged = new Sprite(ImageLoader.load("lizardUncaged.png"));
		lizardUncaged.setScale(3);
		lizardUncaged.setLocation(lizardLocation.x, lizardLocation.y);

		// add zookeeper
		// zookeeperTitle = new ZookeeperEnemy(getMapTile(20,
		// 7).getLocation().subtractY(5), Direction.LEFT);
		// zookeeperTitle.setScale(3);
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
		sharkUncaged.draw(graphicsHandler);
		mountainGoatUncaged.draw(graphicsHandler);
		monkeyUncaged.draw(graphicsHandler);
		penguinUncaged.draw(graphicsHandler);
		parrotUncaged.draw(graphicsHandler);
		lizardUncaged.draw(graphicsHandler);
		// zookeeperTitle.draw(graphicsHandler);
	}

}
