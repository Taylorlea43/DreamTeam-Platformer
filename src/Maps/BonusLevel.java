package Maps;

import Enemies.*;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.LevelKey;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
import Utils.Direction;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class BonusLevel extends Map {

    public BonusLevel()
    {
        super("level2.txt", new DesertTileset());
        this.playerStartPosition = getMapTile(2, 8).getLocation();
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        return enemies;
    }





}
