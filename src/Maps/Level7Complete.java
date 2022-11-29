package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.SavannahTileset;

public class Level7Complete extends Map
{
	public Level7Complete() 
	{
		super("level7Complete.txt", new SavannahTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}