package Maps;

import Enemies.SquirrelEnemy;
import Enemies.DinosaurEnemy;
import Enemies.ZookeeperEnemy;
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
public class Level1 extends Map 
{
	private LevelKey key;
	
	public Level1() 
	{
		super("level2.txt", new DesertTileset());
		this.playerStartPosition = getMapTile(2, 8).getLocation();
	}

	@Override
	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();


		enemies.add(new ZookeeperEnemy(getMapTile(15, 6).getLocation().addY(10), Direction.LEFT));

		//enemies.add(new DinosaurEnemy(getMapTile(19, 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
				//Direction.RIGHT));
		return enemies;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

//		enhancedMapTiles.add(new HorizontalMovingPlatform(ImageLoader.load("GreenPlatform.png"),
//				getMapTile(24, 6).getLocation(), getMapTile(27, 6).getLocation(), TileType.JUMP_THROUGH_PLATFORM, 3,
//				new Rectangle(0, 6, 16, 4), Direction.RIGHT));

		enhancedMapTiles.add(new EndLevelBox(getMapTile(72, 10).getLocation(), "Lizard2.png", key, 24, 24));

		return enhancedMapTiles;
	}
	
	//@Override
	//public ArrayList<NPC> loadNPCs() {
		//ArrayList<NPC> npcs = new ArrayList<>();

		//npcs.add(new Walrus(getMapTile(30, 10).getLocation().subtractY(13)));

		//return npcs;
	//}

}
