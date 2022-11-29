package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.SavannahTileset;

public class Level10Complete extends Map
{
	public Level10Complete() 
	{
		super("level10Complete.txt", new SavannahTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}