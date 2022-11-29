package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.MountainTileset;

public class Level6Complete extends Map
{
	public Level6Complete() 
	{
		super("level6Complete.txt", new MountainTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}