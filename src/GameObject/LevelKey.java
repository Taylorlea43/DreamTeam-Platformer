package GameObject;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Screen;
import Level.MapEntity;
import Level.Player;
import Sounds.AudioPlayer;

public class LevelKey extends MapEntity
{
	public static boolean gotKey = false;
	public Screen screen;
	public float x, y;

	public LevelKey(float x, float y, String imageName) 
	{
		super(x, y, new Frame(ImageLoader.load(imageName)));
		this.x = x;
		this.y = y;
		this.setScale(2);
	}

	public void check(Player player) 
	 {
		 if((intersects(player) && gotKey == false) | (overlaps(player) && gotKey == false)) 
		 {
			 gotKey = true;
			 
			 try
				{
					AudioPlayer keySound = new AudioPlayer (false, "Resources/KeyGet_Sound.wav");
					keySound.play();
				}
				
				catch(Exception e)
				{
					System.out.println("Error with sound");
				}
		 }
	 }
	 	    
	 public boolean gotKey() 
	 {
		 return gotKey;
	 }

	 public void setGotKey(boolean t){
		gotKey = t;
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
