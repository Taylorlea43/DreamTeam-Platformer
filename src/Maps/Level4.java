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
        enemies.add(new PolarBearEnemy(getMapTile(10,6).getLocation(), Direction.LEFT));
        enemies.add(new SealEnemy(getMapTile(40,6).getLocation(), Direction.LEFT));
        enemies.add(new PolarBearEnemy(getMapTile(22, 6).getLocation(), Direction.LEFT));
        enemies.add(new SealEnemy(getMapTile(63, 6).getLocation(), Direction.LEFT));

        enhancedMapTiles.add(new EndLevelBox(getMapTile(73, 9).getLocation(), "penguin.png", key, 30, 26));


        return enhancedMapTiles;
    }
}
