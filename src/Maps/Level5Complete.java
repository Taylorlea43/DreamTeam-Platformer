package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.JungleTileset;

public class Level5Complete extends Map
{
	public Level5Complete() 
	{
		super("level5Complete.txt", new JungleTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}