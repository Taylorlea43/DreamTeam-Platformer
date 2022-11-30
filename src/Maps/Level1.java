package Maps;

import Enemies.*;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.LevelKey;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Utils.Direction;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class Level1 extends Map {
	private LevelKey key;

	public Level1() {
		super("level2.txt", new DesertTileset());
		this.playerStartPosition = getMapTile(1, 13).getLocation();
	}

	@Override
	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();

		enemies.add(new cowboyZookeeperEnemy(getMapTile(15, 10).getLocation().addY(10), Direction.LEFT));
		enemies.add(new ScorpionEnemy(getMapTile(47, 16).getLocation().addY(20), Direction.LEFT));
		enemies.add(new ScorpionEnemy(getMapTile(48, 16).getLocation().addY(20), Direction.LEFT));
		enemies.add(new ScorpionEnemy(getMapTile(49, 16).getLocation().addY(20), Direction.LEFT));
		enemies.add(new ScorpionEnemy(getMapTile(16, 15).getLocation().addY(20), Direction.LEFT));
		enemies.add(new cowboyZookeeperEnemy(getMapTile(34, 11).getLocation().addY(10), Direction.LEFT));
		enemies.add(new ScorpionEnemy(getMapTile(53, 11).getLocation().addY(20), Direction.LEFT));

		return enemies;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

		enhancedMapTiles.add(new EndLevelBox(getMapTile(72, 10).getLocation(), "Lizard2.png", key, 24, 24));

		return enhancedMapTiles;
	}

}
