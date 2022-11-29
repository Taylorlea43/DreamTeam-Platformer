package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.SavannahTileset;

public class Level9Complete extends Map
{
	public Level9Complete() 
	{
		super("level9Complete.txt", new SavannahTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}