package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;

public class TutorialComplete extends Map
{
	public TutorialComplete() 
	{
		super("TutorialComplete.txt", new CommonTileset());
	}
	
	public void draw(GraphicsHandler graphicsHandler)
	{
		super.draw(graphicsHandler);
	}
}