package Maps;

import Enemies.FlyingEnemy2;
import Enemies.JellyfishEnemy;
import Enemies.OctopusEnemy;
import Enemies.ZookeeperEnemy;
import Enemies.SquirrelEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.LevelKey;
import GameObject.Rectangle;
import Level.*;
import NPCs.Textbox1;
import NPCs.Textbox2;
import NPCs.Textbox3;
import NPCs.Textbox4;
import NPCs.Textbox5;
import NPCs.Textbox6;
import Tilesets.CommonTileset;
import Utils.Direction;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

	private LevelKey key;

	public TestMap() {
		super("test_map.txt", new CommonTileset());
		this.playerStartPosition = getMapTile(1, 11).getLocation();

	}

	@Override
	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		enemies.add(new SquirrelEnemy(getMapTile(66, 6).getLocation().addY(20), Direction.LEFT));
		enemies.add(new ZookeeperEnemy(getMapTile(58, 9).getLocation().addY(10), Direction.LEFT));

//        enemies.add(new DinosaurEnemy(getMapTile(19, 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2), Direction.RIGHT));

		return enemies;
	}

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

		enhancedMapTiles.add(new EndLevelBox(getMapTile(97, 7).getLocation(), "Lizard2.png", key, 24, 24));

		return enhancedMapTiles;
	}

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>(); 

		npcs.add(new Textbox1(getMapTile(1, 5).getLocation(), Direction.RIGHT));
		npcs.add(new Textbox2(getMapTile(20, 2).getLocation(), Direction.RIGHT));
		npcs.add(new Textbox3(getMapTile(20, 6).getLocation(), Direction.RIGHT));
		npcs.add(new Textbox4(getMapTile(35, 3).getLocation(), Direction.RIGHT));
		npcs.add(new Textbox5(getMapTile(53, 1).getLocation(), Direction.RIGHT));
		npcs.add(new Textbox6(getMapTile(86, 2).getLocation(), Direction.RIGHT));

        return npcs;
    }

}
