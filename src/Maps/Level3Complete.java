package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CloudTileset;
import Tilesets.CommonTileset;

public class Level3Complete extends Map
{
	public Level3Complete() 
	{
		super("level3Complete.txt", new CloudTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}