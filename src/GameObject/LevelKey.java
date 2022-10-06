package GameObject;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Screen;
import Level.MapEntity;
import Level.Player;

public class LevelKey extends MapEntity
{
	public boolean gotKey = false;
	public Screen screen;
	public float x, y;

	public LevelKey(float x, float y, String imageName) 
	{
		super(x, y, new Frame(ImageLoader.load(imageName)));
		this.x = x;
		this.y = y;
	}
	
	
	 public void check(Player player) 
	 {
		 if((intersects(player) && gotKey == false) | (overlaps(player) && gotKey == false)) 
		 {
			 gotKey = true;
			 System.out.println("touched key");
		 }
	 }
	 	    
	 public boolean gotKey() 
	 {
		 return gotKey;
	 }


    @Override
    public void draw(GraphicsHandler graphicsHandler) 
    {
    	if(gotKey == false) 
    	{
    		super.draw(graphicsHandler);
    	}
    }
}
