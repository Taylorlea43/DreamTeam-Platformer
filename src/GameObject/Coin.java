package GameObject;

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
		super(x, y, new Frame(ImageLoader.load("coin.png")));
		this.x = x;
		this.y = y;
		this.setScale(3);
		coinCount = 0;
	}
	
	
	 public void check(Player player) {
		 if(overlaps(player)) {
			 gotCoin = true;
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
