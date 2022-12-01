package Maps;
import java.util.ArrayList;

import Enemies.DinosaurEnemy;
import Enemies.HyenaEnemy;
import Enemies.PantherEnemy;
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
import Tilesets.SavannahTileset;
import Utils.Direction;

public class Level10 extends Map {

    private LevelKey key;

    public Level10() {
        super("level11.txt", new SavannahTileset());
        this.playerStartPosition = getMapTile(1, 13).getLocation();

    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new HyenaEnemy(getMapTile(24,11).getLocation(), Direction.LEFT));
        enemies.add(new PantherEnemy(getMapTile(42,14).getLocation(), Direction.LEFT));
        enemies.add(new PantherEnemy(getMapTile(55,14).getLocation(), Direction.RIGHT));
        enemies.add(new PantherEnemy(getMapTile(50,14).getLocation(), Direction.LEFT));
        enemies.add(new HyenaEnemy(getMapTile(36, 8).getLocation(), Direction.LEFT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 10).getLocation(), "Lion.png", key, 35, 24));


        return enhancedMapTiles;
    }
}
