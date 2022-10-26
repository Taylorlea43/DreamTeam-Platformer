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

public class Level2 extends Map 
{
	private LevelKey key;

	public Level2() {
		super("level2.txt", new DesertTileset());
		this.playerStartPosition = getMapTile(2, 11).getLocation();

	}
	public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        //enemies.add(new BugEnemy(getMapTile(15, 8).getLocation().addY(20), Direction.LEFT));
        enemies.add(new ZookeeperEnemy(getMapTile(15, 6).getLocation().addY(10), Direction.LEFT)); 

        return enemies; 
    }
	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

	
		enhancedMapTiles.add(new EndLevelBox(getMapTile(27, 7).getLocation(), "Bunny.png", key, 24, 24));

		return enhancedMapTiles;
	}	
}
