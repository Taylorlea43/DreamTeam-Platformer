package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.CommonTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    private Sprite girl;

    public TitleScreenMap() {
        super("title_screen_map.txt", new CommonTileset());
        Point girlLocation = getMapTile(6, 6).getLocation().subtractX(24).subtractY(6);
        girl = new Sprite(ImageLoader.loadSubImage("girlNoLines.png", Colors.MAGENTA, 0, 0, 55, 85));
        girl.setScale(2);
        girl.setLocation(girlLocation.x, girlLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        girl.draw(graphicsHandler);
    } 

}
