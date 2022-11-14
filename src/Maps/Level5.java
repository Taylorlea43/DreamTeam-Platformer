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
        this.playerStartPosition = getMapTile(7, 63).getLocation();

    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new KoalaEnemy(getMapTile(10,6).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(20,10).getLocation(), Direction.LEFT));
        enemies.add(new KoalaEnemy(getMapTile(12, 28).getLocation(), Direction.LEFT));
        enemies.add(new SnakeEnemy(getMapTile(19, 50).getLocation(), Direction.LEFT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(8, 0).getLocation(), "monkey.png", key, 24, 24));


        return enhancedMapTiles;
    }
}
