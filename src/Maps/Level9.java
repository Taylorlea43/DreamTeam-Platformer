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

public class Level9 extends Map {

    private LevelKey key;

    public Level9() {
        super("level10.txt", new SavannahTileset());
        this.playerStartPosition = getMapTile(1, 13).getLocation();

    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new HyenaEnemy(getMapTile(14,14).getLocation(), Direction.LEFT));
        enemies.add(new HyenaEnemy(getMapTile(16,14).getLocation(), Direction.RIGHT));
        enemies.add(new HyenaEnemy(getMapTile(23,14).getLocation(), Direction.LEFT));
        enemies.add(new HyenaEnemy(getMapTile(29,14).getLocation(), Direction.LEFT));
        enemies.add(new HyenaEnemy(getMapTile(34,14).getLocation(), Direction.RIGHT));
        enemies.add(new HyenaEnemy(getMapTile(38,14).getLocation(), Direction.LEFT));
        enemies.add(new HyenaEnemy(getMapTile(42,14).getLocation(), Direction.RIGHT));

        enemies.add(new PantherEnemy(getMapTile(54,13).getLocation(), Direction.LEFT));
        enemies.add(new PantherEnemy(getMapTile(64, 11).getLocation(), Direction.LEFT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 9).getLocation(), "elephant.png", key, 25, 25));


        return enhancedMapTiles;
    }
}

