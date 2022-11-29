package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.ForestTileset;

public class Level2Complete extends Map
{
	public Level2Complete() 
	{
		super("level2Complete.txt", new ForestTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}