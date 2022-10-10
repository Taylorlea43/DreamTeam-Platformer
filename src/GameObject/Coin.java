package GameObject;

import java.awt.image.BufferedImage;
import java.util.Map;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Level.MapEntity;
import Level.Player;

public class Coin extends MapEntity{
	
	public boolean gotCoin = false;
	public Screen screen;
	public int coinCount;
	public float x, y;

	public Coin(float x, float y) {
		super( x, y, new Frame(ImageLoader.load("Coins.png")));
		this.x = x;
		this.y = y;
		this.setScale(3);
		coinCount = 0;
	}
	
	
	 public void check(Player player) {
		 if((intersects(player) && gotCoin == false) | (overlaps(player) && gotCoin == false)) {
			 gotCoin = true;
			 coinCount++;
		 }
	 }
	    
	 public boolean gotCoin() {
		 return gotCoin;
	 }
	 
	 public int getCoinCount() {
		 return coinCount;
	 }
	

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
    	if( gotCoin == false) {
        super.draw(graphicsHandler);
    	}
    }

}
