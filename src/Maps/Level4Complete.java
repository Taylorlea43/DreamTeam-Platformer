package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.ArticTileset;
import Tilesets.CommonTileset;

public class Level4Complete extends Map
{
	public Level4Complete() 
	{
		super("level4Complete.txt", new ArticTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}