package GameObject;

import java.util.HashMap;

import Level.MapEntity;

public class LevelKey extends MapEntity
{
	public LevelKey(float x, float y)
	{
		super(x, y);
		
		this.draw(null);
		this.getLocation();
	}
	public LevelKey(float x, float y, Frame frame)
	{
		super(x, y, frame);
	}
	public LevelKey(float x, float y, Frame[] frames) 
	{
		super(x, y, frames);
	}
	public LevelKey(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) 
	{
		super(x, y, animations, startingAnimation);
	}
	public LevelKey(float x, float y, SpriteSheet spriteSheet, String startingAnimation) 
	{
		super(x, y, spriteSheet, startingAnimation);
	}
}
