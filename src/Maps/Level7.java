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
import Tilesets.SavannahTileset;
import Utils.Direction;

public class Level7 extends Map {

    private LevelKey key;

    public Level7() {
        super("level8.txt", new SavannahTileset());
        this.playerStartPosition = getMapTile(0, 7).getLocation();

    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new HyenaEnemy(getMapTile(10,6).getLocation(), Direction.LEFT));
        enemies.add(new PantherEnemy(getMapTile(40,6).getLocation(), Direction.LEFT));
        enemies.add(new HyenaEnemy(getMapTile(22, 6).getLocation(), Direction.LEFT));
        enemies.add(new PantherEnemy(getMapTile(63, 6).getLocation(), Direction.LEFT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 10).getLocation(), "girrafe.png", key, 24, 48));


        return enhancedMapTiles;
    }

}