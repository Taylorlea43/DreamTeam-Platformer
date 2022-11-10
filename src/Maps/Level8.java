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

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        enemies.add(new OctopusEnemy(getMapTile(10,6).getLocation(), Direction.LEFT));
        enemies.add(new JellyfishEnemy(getMapTile(40,6).getLocation(), Direction.LEFT));
        enemies.add(new OctopusEnemy(getMapTile(22, 6).getLocation(), Direction.LEFT));
        enemies.add(new JellyfishEnemy(getMapTile(63, 6).getLocation(), Direction.LEFT));

        enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 11).getLocation(), "shark.png", key, 25, 18));


        return enhancedMapTiles;
    }
}
