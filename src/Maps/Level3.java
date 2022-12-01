package Maps;

import java.util.ArrayList;

import Enemies.*;
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
import Tilesets.CloudTileset;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Tilesets.ForestTileset;
import Utils.Direction;

public class Level3 extends Map {
	
	private LevelKey key;

	public Level3() {
		super("level4.txt", new CloudTileset());
		this.playerStartPosition = getMapTile(0, 11).getLocation();
	}

	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		enemies.add(new AirplaneEnemy(getMapTile(9, 1).getLocation(), Direction.LEFT));
		enemies.add(new CrowEnemy(getMapTile(10,6).getLocation(), Direction.LEFT));
		enemies.add(new AirplaneEnemy(getMapTile(40,1).getLocation(), Direction.LEFT));
		enemies.add(new CrowEnemy(getMapTile(22, 6).getLocation(), Direction.LEFT));
		enemies.add(new AirplaneEnemy(getMapTile(63, 1).getLocation(), Direction.LEFT));
		enemies.add(new CrowEnemy(getMapTile(51,6).getLocation(), Direction.LEFT));
		enemies.add(new CrowEnemy(getMapTile(72,5).getLocation(), Direction.LEFT));

		return enemies;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 7).getLocation(), "parrot.png", key, 24, 24));
		return enhancedMapTiles;
	}
}
