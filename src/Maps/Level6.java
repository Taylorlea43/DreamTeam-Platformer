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
import Tilesets.JungleTileset;
import Tilesets.MountainTileset;
import Utils.Direction;

public class Level6 extends Map {

    private LevelKey key;

    public Level6() {
        super("level7.txt", new MountainTileset());
        this.playerStartPosition = getMapTile(13, 28).getLocation();

    }

    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BuffaloEnemy(getMapTile(36,18).getLocation(), Direction.LEFT));
        enemies.add(new BuffaloEnemy(getMapTile(34, 28).getLocation(), Direction.LEFT));
        enemies.add(new CougarEnemy(getMapTile(25, 16).getLocation().addY(10), getMapTile(30, 16).getLocation(), Direction.LEFT));
        enemies.add(new CougarEnemy(getMapTile(19, 20).getLocation().addY(10), getMapTile(23, 21).getLocation(), Direction.LEFT));
        enemies.add(new CougarEnemy(getMapTile(11, 19).getLocation().addY(10), getMapTile(14, 19).getLocation(), Direction.LEFT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();


        enhancedMapTiles.add(new EndLevelBox(getMapTile(48, 27).getLocation(), "mountainGoat.png", key, 25, 25));


        return enhancedMapTiles;
    }
}
