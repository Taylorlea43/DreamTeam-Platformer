package Maps;

import java.util.ArrayList;

import Enemies.DinosaurEnemy;
import Enemies.ZookeeperEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.LevelKey;
import GameObject.Rectangle;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.TileType;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Utils.Direction;

public class Level3 extends Map {
	
	private LevelKey key;

	public Level3() {
		super("level2.txt", new DesertTileset());
		this.playerStartPosition = getMapTile(0, 7).getLocation();

	}

	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();

		return enemies;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


		enhancedMapTiles.add(new EndLevelBox(getMapTile(23, 7).getLocation(), "parrot.png", key, 24, 24));


		return enhancedMapTiles;
	}
}
