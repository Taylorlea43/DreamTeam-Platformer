package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.UnderwaterTileset;

public class Level8Complete extends Map
{
	public Level8Complete() 
	{
		super("level8Complete.txt", new UnderwaterTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}