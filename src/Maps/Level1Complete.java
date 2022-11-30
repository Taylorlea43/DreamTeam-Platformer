package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.DesertTileset;

public class Level1Complete extends Map
{
	public Level1Complete() 
	{
		super("level1Complete.txt", new DesertTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}