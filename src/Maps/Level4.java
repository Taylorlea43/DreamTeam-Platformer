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
import Tilesets.ArticTileset;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Utils.Direction;

public class Level4 extends Map {

    private LevelKey key;

    public Level4() {
        super("level5.txt", new ArticTileset());
        this.playerStartPosition = getMapTile(0, 7).getLocation();

    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(23, 9).getLocation(), "penguin.png", key, 30, 26));


        return enhancedMapTiles;
    }
}
