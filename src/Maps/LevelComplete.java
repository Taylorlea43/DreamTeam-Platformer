package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;

public class LevelComplete extends Map
{
	public LevelComplete() 
	{
		super("levelComplete.txt", new CommonTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}

}