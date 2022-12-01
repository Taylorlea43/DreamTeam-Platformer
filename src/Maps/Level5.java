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
import Tilesets.ArticTileset;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Tilesets.JungleTileset;
import Utils.Direction;

public class Level5 extends Map {

    private LevelKey key;

    public Level5() {
        super("level6.txt", new JungleTileset());
        this.playerStartPosition = getMapTile(7, 62).getLocation();
    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new SnakeEnemy(getMapTile(10, 50).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(4, 49).getLocation(), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getMapTile(19, 50).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(18, 30).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(20, 36).getLocation(), Direction.LEFT));

        enemies.add(new KoalaEnemy(getMapTile(14,28).getLocation(), Direction.LEFT));
        enemies.add(new KoalaEnemy(getMapTile(5,44).getLocation(), Direction.LEFT));
        enemies.add(new KoalaEnemy(getMapTile(4,21).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(10, 11).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(4, 6).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(17, 6).getLocation(), Direction.LEFT));
        enemies.add(new KoalaEnemy(getMapTile(24,14).getLocation(), Direction.LEFT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(28, 1).getLocation(), "monkey.png", key, 24, 24));


        return enhancedMapTiles;
    }
}
