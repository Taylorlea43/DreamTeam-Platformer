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
import Tilesets.JungleTileset;
import Tilesets.MountainTileset;
import Utils.Direction;

public class Level6 extends Map {

    private LevelKey key;

    public Level6() {
        super("level7.txt", new MountainTileset());
        this.playerStartPosition = getMapTile(7, 13).getLocation();

    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(8, 8).getLocation(), "mountainGoat.png", key, 25, 25));


        return enhancedMapTiles;
    }
}
