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
		this.playerStartPosition = getMapTile(1, 17).getLocation();

	}

	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		enemies.add(new OctopusEnemy(getMapTile(35, 0).getLocation(), Direction.LEFT, 8));
		enemies.add(new OctopusEnemy(getMapTile(35, 0).getLocation(), Direction.LEFT, 2));
		enemies.add(new OctopusEnemy(getMapTile(43, 0).getLocation(), Direction.LEFT, 5));
		enemies.add(new OctopusEnemy(getMapTile(53, 0).getLocation(), Direction.LEFT, 7));
		enemies.add(new OctopusEnemy(getMapTile(61, 0).getLocation(), Direction.LEFT, 1));
		enemies.add(new OctopusEnemy(getMapTile(61, 0).getLocation(), Direction.LEFT, 9));

		enemies.add(new JellyfishEnemy(getMapTile(19, 10).getLocation(), getMapTile(19, 12).getLocation(),
				getMapTile(18, 12).getLocation(), getMapTile(18, 10).getLocation(), Direction.LEFT));

		enemies.add(new JellyFishEnemy2(getMapTile(25, 9).getLocation(), getMapTile(25, 12).getLocation(),
				getMapTile(24, 12).getLocation(), getMapTile(24, 9).getLocation(), Direction.LEFT));

		enemies.add(new JellyFishEnemy3(getMapTile(18, 3).getLocation(), getMapTile(18, 4).getLocation(),
				getMapTile(17, 4).getLocation(), getMapTile(17, 3).getLocation(), Direction.LEFT));

		enemies.add(new JellyFishEnemy4(getMapTile(26, 3).getLocation(), getMapTile(26, 5).getLocation(),
				getMapTile(25, 5).getLocation(), getMapTile(25, 3).getLocation(), Direction.LEFT));

		enemies.add(new JellyFishEnemy5(getMapTile(57, 9).getLocation(), getMapTile(57, 14).getLocation(),
				getMapTile(45, 14).getLocation(), getMapTile(45, 9).getLocation(), Direction.LEFT));
		return enemies;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

		enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 11).getLocation(), "shark.png", key, 25, 18));

		return enhancedMapTiles;
	}
}
