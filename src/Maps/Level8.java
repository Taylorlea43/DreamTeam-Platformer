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
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Tilesets.UnderwaterTileset;
import Utils.Direction;

public class Level8 extends Map {

	private LevelKey key;

	public Level8() {
		super("level9.txt", new UnderwaterTileset());
		this.playerStartPosition = getMapTile(0, 7).getLocation();

	}

	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		enemies.add(new OctopusEnemy(getMapTile(35, 0).getLocation(), Direction.LEFT, 8));
		enemies.add(new OctopusEnemy(getMapTile(35, 0).getLocation(), Direction.LEFT, 2));
		enemies.add(new OctopusEnemy(getMapTile(43, 0).getLocation(), Direction.LEFT, 5));
		enemies.add(new OctopusEnemy(getMapTile(53, 0).getLocation(), Direction.LEFT, 7));
		enemies.add(new OctopusEnemy(getMapTile(61, 0).getLocation(), Direction.LEFT, 1));
		enemies.add(new OctopusEnemy(getMapTile(61, 0).getLocation(), Direction.LEFT, 9));

		enemies.add(new JellyfishEnemy(getMapTile(20, 6).getLocation(), getMapTile(20, 9).getLocation(),
				getMapTile(17, 9).getLocation(), getMapTile(17, 6).getLocation(), Direction.LEFT));

		return enemies;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

		enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 11).getLocation(), "shark.png", key, 25, 18));

		return enhancedMapTiles;
	}
}
