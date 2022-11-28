package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;

public class Level1Complete extends Map
{
	public Level1Complete() 
	{
		super("level1Complete.txt", new CommonTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}

}
